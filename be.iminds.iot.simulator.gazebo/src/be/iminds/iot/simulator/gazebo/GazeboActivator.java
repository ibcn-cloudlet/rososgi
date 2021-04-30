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
package be.iminds.iot.simulator.gazebo;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;

import be.iminds.iot.simulator.api.Simulator;

/**
 * Check and connect to external Gazebo via ROS.
 * 
 * @author tverbele
 *
 */
@Component(service = {NodeMain.class})
public class GazeboActivator extends AbstractNodeMain{

	private BundleContext context;
	private ServiceRegistration<Simulator> reg;
	
	// in case we need to launch Gazebo ourselves
	private ConfigurationAdmin ca;
	private boolean launchNative = false;
	private Configuration nativeConfig;
	
	private volatile boolean active = false;
	
	@Activate
	void activate(BundleContext context, Map<String, Object> config){
		this.context = context;
		String launch = context.getProperty("gazebo.launch");
		if(launch != null){
			launchNative = Boolean.parseBoolean(launch);
		}
	}
	
	@Deactivate
	void deactivate(){
		active = false;
		if(nativeConfig !=null){
			try {
				nativeConfig.delete();
			} catch (IOException e) {
			}
		}
	}
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("gazebo/activator");
	}
	
	@Override
	public void onStart(ConnectedNode connectedNode){
		active = true;
		while(reg == null && active){
			try {
				Gazebo gazebo = new Gazebo(connectedNode);
				gazebo.stop();
				
				Hashtable<String, Object> properties = new Hashtable<String, Object>();
				properties.put("osgi.command.scope", "gazebo");
				properties.put("osgi.command.function", new String[]{
						"start",
						"pause",
						"stop",
						"tick",
						"loadScene",
						"getPosition",
						"setPosition",
						"getOrientation",
						"setOrientation",
						"checkCollisions"		
				});
				reg = context.registerService(Simulator.class, gazebo, properties);
			} catch(Exception e){
				//e.printStackTrace();
				if(nativeConfig == null && launchNative){
					// try to load gazebo ourselves?
					try {
						nativeConfig = ca.createFactoryConfiguration("be.iminds.iot.simulator.gazebo.Native", null);
						nativeConfig.update(new Hashtable());
					} catch(Exception ex){}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		if(reg == null){
			System.out.println("Failed to connect to Gazebo!");
		}
	}
	
	@Override
	public void onShutdown(Node node) {
		if(reg != null){
			reg.unregister();
		}
	}
	
	@Reference
	void setConfigurationAdmin(ConfigurationAdmin ca){
		this.ca = ca;
	}
}
