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
package be.iminds.iot.robot.erlerover.ros;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.promise.Deferred;
import org.osgi.util.promise.Promise;
import org.ros.exception.RemoteException;
import org.ros.exception.ServiceNotFoundException;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;
import org.ros.node.service.ServiceClient;
import org.ros.node.service.ServiceResponseListener;
import org.ros.node.topic.Subscriber;

import mavros_msgs.ParamSetRequest;
import mavros_msgs.ParamSetResponse;
import mavros_msgs.ParamValue;
import mavros_msgs.SetModeRequest;
import mavros_msgs.SetModeResponse;
import mavros_msgs.State;
import sensor_msgs.LaserScan;

@Component(service = {NodeMain.class},
	name="be.iminds.iot.robot.erlerover.ros.Rover",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class RoverRosController extends AbstractNodeMain {

	private String name;
	private RoverImpl rover;
	
	private BundleContext context;
	private volatile boolean active = false;
	
	private ConnectedNode node = null;
	private ServiceClient<ParamSetRequest, ParamSetResponse> setParam = null;
	private ServiceClient<SetModeRequest, SetModeResponse> setMode = null;
		
	private Subscriber<mavros_msgs.State> subscriber;
	private int count = 0;
	
	@Activate
	void activate(BundleContext context, Map<String, Object> config){
		this.context = context;
		
		name = config.get("name").toString();
		if(name == null){
			name = "Erle Rover";
		}
	}
	
	@Deactivate
	void deactivate(){
		active = false;
	}
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("elrerover/controller");
	}
	
	@Override
	public void onStart(ConnectedNode connectedNode){
		this.node = connectedNode;
		this.active = true;
		while(setParam == null && active){ // TODO add timeout?
			try {
				setParam = connectedNode.newServiceClient("/mavros/param/set", mavros_msgs.ParamSet._TYPE);
			} catch (ServiceNotFoundException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		while(setMode == null && active){ // TODO add timeout?
			try {
				setMode = connectedNode.newServiceClient("/mavros/set_mode", mavros_msgs.SetMode._TYPE);
			} catch (ServiceNotFoundException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		if(setParam == null || setMode == null)
			return;
		
		// set SYSID_MYGCS to 1 for override control
		setParam("SYSID_MYGCS", 1)   // retry until ok
			.then(p -> setParam("FS_ACTION", 0))
			.then(p -> setMode("MANUAL",0));
		
		// wait until initialized before bringing Rover service online
		subscriber = node.newSubscriber("/mavros/state", mavros_msgs.State._TYPE);
		subscriber.addMessageListener(new MessageListener<State>() {
			@Override
			public void onNewMessage(State state) {
				if(state.getConnected() && state.getMode().equals("MANUAL")){
					count++;
					if(count > 3){
						// this brings online Rover service when armed
						// apparently we don't get state.getArmed True when it is
						// therefore we count the amount of messages that we are in MANUAL
						// if we are in 3 subsequent MANUAL states we think it is ok
						try {
							rover = new RoverImpl(name, context, node);
							rover.register();
						} catch(Exception e){
							System.out.println("Failed to bring online Rover service");
							e.printStackTrace();
						}
						subscriber.shutdown();
					} 
				} else {
					count = 0;
				}
			}
		});
	}
	
	@Override
	public void onShutdown(Node node) {
		try {
			rover.stop();
		} catch(Exception e){}
		
		rover.unregister();
	}

	private Promise<Void> setParam(String param, int value){
		return setParam(param, value, true); // auto retry until worked - might still be initializing
	}
	
	private Promise<Void> setParam(String param, int value, boolean retry){
		Deferred<Void> deferred = new Deferred<>();
		
		final ParamSetRequest request = setParam.newMessage();
		request.setParamId(param);
		ParamValue val = request.getValue();
		val.setInteger(value);
		request.setValue(val);
		setParam.call(request, new ServiceResponseListener<ParamSetResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				ex.printStackTrace();
				deferred.fail(ex);
			}

			@Override
			public void onSuccess(ParamSetResponse r) {
				if(r.getSuccess()){
					deferred.resolve(null);
				} else {
					// try again?!
					if(retry){
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
						deferred.resolveWith(setParam(param, value, true));
					} else {
						deferred.resolve(null);
					}
				}
			}
		});
		return deferred.getPromise();
	}
	
	
	private Promise<Void> setMode(String mode, int value){
		Deferred<Void> deferred = new Deferred<>();
		
		final SetModeRequest request = setMode.newMessage();
		request.setCustomMode(mode);
		request.setBaseMode((byte)value);
		setMode.call(request, new ServiceResponseListener<SetModeResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				ex.printStackTrace();
				deferred.fail(ex);
			}

			@Override
			public void onSuccess(SetModeResponse r) {
				if(r.getSuccess()){
					deferred.resolve(null);
				} else {
					deferred.fail(new Exception(r.toRawMessage().toString()));
				}
			}
		});
		return deferred.getPromise();
	}
}
