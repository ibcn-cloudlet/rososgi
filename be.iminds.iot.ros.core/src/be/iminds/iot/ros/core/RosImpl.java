/*******************************************************************************
 * Copyright (C) 2021 Ghent University - imec, IDLab
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Tim Verbelen
 *   Steven Bohez
 *   Elias De Coninck
 ******************************************************************************/
package be.iminds.iot.ros.core;

import java.io.File;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.ros.RosCore;
import org.ros.concurrent.DefaultScheduledExecutorService;
import org.ros.master.client.MasterStateClient;
import org.ros.master.client.ServiceSystemState;
import org.ros.master.client.SystemState;
import org.ros.master.client.TopicSystemState;
import org.ros.master.client.TopicType;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.DefaultNodeMainExecutor;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;

import be.iminds.iot.ros.api.Ros;

@Component(service = {Ros.class},
	immediate=true,
	property = {"osgi.command.scope=ros", 
		"osgi.command.function=env",	
		"osgi.command.function=nodes",
		"osgi.command.function=topics",
		"osgi.command.function=publishers",
		"osgi.command.function=subscribers",
		"osgi.command.function=services",
		"osgi.command.function=providers"})
public class RosImpl extends AbstractNodeMain implements Ros {

	// ROS environment variables
	private URI masterURI;
	private String distro;
	private String namespace;
	private String root;
	private String packagePath;
	
	// ROS core instance (native or rosjava)
	private Process nativeCore;
	private RosCore core;
	
	// rosjava connection to the ROS master
	private MasterStateClient master;

	// construct our own thread pool for rosjava
	private NodeMainExecutor executor;
	private ThreadPoolExecutor pool;
	private int threadCount = 0;

	// also register a node to get access to basic ros info
	private ConnectedNode node;

	
	@Activate
	void activate(BundleContext context) throws Exception {
		try {
			String uri = getVariable("ROS_MASTER_URI", "ros.master.uri", context);
			if(uri==null){
				throw new Exception("No master URI configured!");
			}
			masterURI = new URI(uri);
			distro = getVariable("ROS_DISTRO", "ros.distro", context);
			namespace = getVariable("ROS_NAMESPACE", "ros.namespace", context);
			root = getVariable("ROS_ROOT", "ros.root", context);
			packagePath = getVariable("ROS_PACKAGE_PATH", "ros.package.path", context);
		} catch(Exception e){
			System.err.println("Error setting up the ROS environment: "+e.getMessage());
			throw e;
		} 
		
		// create threadpool for running additional rosjava nodes
		// these parameters are equal as for CachedThreadPool ... change if useful
		pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, 
				new SynchronousQueue<Runnable>(), new ThreadFactory() {	
					@Override
					public Thread newThread(Runnable r) {
						return new Thread(r, "rosjava-pool-"+(threadCount++));
					}
				});
		executor = DefaultNodeMainExecutor.newDefault(new DefaultScheduledExecutorService(pool));

		// start ROS core if required
		boolean start = !rosCoreActive();
		if(start){
			boolean startNative = false;
			String rosCoreNative = context.getProperty("ros.core.native");
			if(rosCoreNative != null){
				startNative = Boolean.parseBoolean(rosCoreNative);
			}
			
			if(startNative){
				// native ROScore process
				ProcessBuilder builder = new ProcessBuilder("roscore", "-p "+masterURI.getPort());
				builder.environment().put("ROS_MASTER_URI", masterURI.toString());
				// builder.inheritIO();
				nativeCore = builder.start();
			} else {
				// rosjava ROScore implementation
				core = RosCore.newPublic(masterURI.getHost(), masterURI.getPort());
				core.start();
				System.out.println("ROS core service [/rosout] started on "+core.getUri());
			}
		}
		
		// block until ROS core is initialized
		// TODO add timeout?
		while(!rosCoreActive()){
			Thread.sleep(100);
		}
		
		// add this node
		addNode(this);
	}
	
	@Deactivate
	void deactivate() throws Exception {
		removeNode(this);
		
		if(core != null)
			core.shutdown();
		
		if(nativeCore != null){
			nativeCore.destroy();
		}
		
		executor.shutdown();
	}
	
	private boolean rosCoreActive(){
		try {
			// try to connect to ROS core
			Socket s = new Socket(masterURI.getHost(), masterURI.getPort());
			s.close();
			return true;
		} catch(Exception e){
			// not active
			return false;
		}
	}


	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("rosinfo/");
	}

	@Override
	public void onStart(final ConnectedNode connectedNode) {
		node = connectedNode;
		master = new MasterStateClient(connectedNode, connectedNode.getMasterUri());
		synchronized(this){
			notifyAll();
		}
	}
	
	
		
	private String getVariable(String environmentKey, String propertyKey, BundleContext context){
		// then try context property
		String ctx = context.getProperty(propertyKey);
		if(ctx != null){
			return ctx;
		} else {
			return System.getenv(environmentKey);
		}
	}
	
	@Override
	public URI masterURI() {
		return masterURI;
	}

	@Override
	public String masterHost(){
		return masterURI.getHost();
	}
	
	@Override
	public int masterPort(){
		return masterURI.getPort();
	}
	
	@Override
	public String distro() {
		return distro;
	}

	@Override
	public String namespace() {
		return namespace;
	}

	@Override
	public File root() {
		if(root==null){
			return new File(".");
		}
		return new File(root);
	}

	@Override
	public List<File> packagePath() {
		List<File> files = new ArrayList<>();
		if(packagePath!=null){
			for(String f : packagePath.split(":")){
				files.add(new File(f));
			}
		}
		return files;
	}
	
	
	/**
	 * This method ensures that any call to the OSGi service waits until the ROS node
	 * is actually intialized. This is a hacky way of making sure the OSGi and ROS lifecycles
	 * can interwork while using DS 
	 */
	private synchronized void waitForInit() {
		if(master!=null){
			return;
		} else {
			try {
				this.wait();
			} catch(InterruptedException e){}
		}
	}
	
	@Override
	public URI nodeURI(String node) {
		waitForInit();
		return master.lookupNode(node);
	}

	@Override
	public Collection<String> nodes() {
		waitForInit();
		// TODO is there a better way to list all nodes?
		SystemState state = master.getSystemState();
		final Set<String> nodes = new HashSet<>();
		state.getTopics().stream().forEach(t -> {
			nodes.addAll(t.getSubscribers());
			nodes.addAll(t.getPublishers());
		});
		return nodes;
	}
	
	@Override
	public Collection<String> topics() {
		waitForInit();
		SystemState state = master.getSystemState();
		return state.getTopics().stream().map(t -> t.getTopicName()).collect(Collectors.toList());
	}

	@Override
	public Collection<String> publishers(String topic) {
		waitForInit();
		SystemState state = master.getSystemState();
		TopicSystemState tss = state.getTopics().stream().filter(t -> t.getTopicName().equals(topic)).findFirst().get();
		return tss.getPublishers();
	}

	@Override
	public Collection<String> subscribers(String topic) {
		waitForInit();
		SystemState state = master.getSystemState();
		TopicSystemState tss = state.getTopics().stream().filter(t -> t.getTopicName().equals(topic)).findFirst().get();
		return tss.getSubscribers();
	}

	@Override
	public String topicType(String topic) {
		waitForInit();
		TopicType type = master.getTopicTypes().stream().filter(t -> t.getName().equals(topic)).findFirst().get();
		return type.getMessageType();
	}

	@Override
	public Collection<String> services() {
		waitForInit();
		SystemState state = master.getSystemState();
		return state.getServices().stream().map(s -> s.getServiceName()).collect(Collectors.toList());
	}

	@Override
	public Collection<String> providers(String service) {
		waitForInit();
		SystemState state = master.getSystemState();
		ServiceSystemState sss = state.getServices().stream().filter(s -> s.getServiceName().equals(service)).findFirst().get();
		return sss.getProviders();
	}
	
	@Override
	public String env(){
		StringBuilder builder = new StringBuilder();
		builder.append("ROS Environmnent \n");
		builder.append(" masterURI: ").append(masterURI).append("\n");
		builder.append(" distro: ").append(distro).append("\n");
		builder.append(" namespace: ").append(namespace).append("\n");
		builder.append(" root: ").append(root).append("\n");
		builder.append(" packagePath: ").append(packagePath).append("\n");
		return builder.toString();
	}
	
	@Override
	public void setParameter(String key, Object value){
		waitForInit();
		if(value instanceof Integer){
			node.getParameterTree().set(key, (Integer)value);
		} else if(value instanceof Double){
			node.getParameterTree().set(key, (Double)value);
		} else if(value instanceof String){
			node.getParameterTree().set(key, (String)value);
		} else if(value instanceof Boolean){
			node.getParameterTree().set(key, (Boolean)value);
		} else if(value instanceof List){
			node.getParameterTree().set(key, (List)value);
		} else if(value instanceof Map){
			node.getParameterTree().set(key, (Map)value);
		} else {
			node.getParameterTree().set(key, String.valueOf(value));
		}
	}	
	
	@Override
	public <T> T getParameter(String key, Class<T> type){
		waitForInit();
		if(type == Integer.class){
			return (T) new Integer(node.getParameterTree().getInteger(key));
		} else if(type == Double.class){
			return (T) new Double(node.getParameterTree().getDouble(key));
		} else if(type == String.class){
			return (T) node.getParameterTree().getString(key);
		} else if(type == Boolean.class){
			return (T) new Boolean(node.getParameterTree().getBoolean(key));
		} else if(type == List.class){
			return (T) node.getParameterTree().getList(key);
		} else if(type == Map.class){
			return (T) node.getParameterTree().getMap(key);
		} 
		return null;
	}
	
	
	@Reference(cardinality=ReferenceCardinality.MULTIPLE, 
			   policy=ReferencePolicy.DYNAMIC)
	public void addNode(NodeMain node) {
		if(node != this)
			waitForInit();
		try {
			NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(masterHost(), masterURI());
			nodeConfiguration.setRosRoot(root());
			nodeConfiguration.setRosPackagePath(packagePath());
			executor.execute(node, nodeConfiguration);
		} catch(Throwable e){
			e.printStackTrace();
		}
	}
	
	public void removeNode(NodeMain node){
		waitForInit();
		try {
			executor.shutdownNodeMain(node);
		} catch(Throwable t){
			t.printStackTrace();
		}
	}

}
