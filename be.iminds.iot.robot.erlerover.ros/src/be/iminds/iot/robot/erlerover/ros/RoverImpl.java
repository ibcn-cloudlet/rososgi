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

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.promise.Deferred;
import org.osgi.util.promise.Promise;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Publisher;

import be.iminds.iot.robot.api.rover.Rover;
import mavros_msgs.OverrideRCIn;

public class RoverImpl implements Rover {

	private final String name;
	private final BundleContext context;
	private ServiceRegistration<Rover> registration;
	
	private final ConnectedNode node;
	
	private Publisher<mavros_msgs.OverrideRCIn> pRC;
	
	private Deferred<Rover> deferred = null;
	private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	private volatile boolean active = false;
	private float throttle = 0;
	private float yaw = 0;
	
	private ExecutorService repeater = Executors.newSingleThreadExecutor();
	
	public RoverImpl(String name, BundleContext context,
			ConnectedNode node){
		this.name = name;
		this.context = context;
		this.node = node;
		
		// TODO expose odometry/IMU information?
		

	}
	
	public void register() throws Exception{
		pRC = node.newPublisher("/mavros/rc/override", mavros_msgs.OverrideRCIn._TYPE);
		
		active = true;
		// keep repeating latest throttle/yaw
		repeater.submit(()->{
			while(active){
				sendCmd();
				try {
					// TODO how often to repeat?
					Thread.sleep(200);
				} catch (Exception e) {
				}
			}
			throttle = 0;
			yaw = 0;
			sendCmd();
		});
		
		Dictionary<String, Object> properties = new Hashtable<>();
		properties.put("name", name);
		registration = 	context.registerService(Rover.class, RoverImpl.this, properties);
	}
	
	public void unregister(){
		active = false;
		
		if(registration != null){
			registration.unregister();
		}
		
		pRC.shutdown();
	}

	@Override
	public Promise<Rover> move(float throttle, float yaw) {
		if(deferred!=null){
			deferred.fail(new Exception("Operation interrupted!"));
			deferred = null;
		}
		// will be resolved immediately
		Deferred<Rover> d = new Deferred<>();

		this.throttle = throttle;
		this.yaw = yaw;
		
		sendCmd();
		
		// resolve immediately
		d.resolve(RoverImpl.this);
		return d.getPromise();
		
	}
	
	@Override
	public synchronized Promise<Rover> waitFor(long time) {
		if(deferred!=null){
			deferred.fail(new Exception("Operation interrupted!"));
		}
		deferred = new Deferred<Rover>();

		executor.schedule(new ResolveTask(deferred), time, TimeUnit.MILLISECONDS);
	
		return deferred.getPromise();
	}

	@Override
	public Promise<Rover> stop() {
		return move(0, 0);
	}
	
	private class ResolveTask implements Runnable {
		
		private Deferred<Rover> deferred;
		
		public ResolveTask(Deferred<Rover> deferred){
			this.deferred = deferred;
		}
		
		@Override
		public void run() {
			if(deferred == RoverImpl.this.deferred){
				synchronized(RoverImpl.this){
					RoverImpl.this.deferred = null;
				}
			}
				
			try {
				deferred.resolve(RoverImpl.this);
			} catch(IllegalStateException e){
				// ignore if already resolved
			}
		}
	}
	
	private void sendCmd(){
		OverrideRCIn cmd = pRC.newMessage();
		short[] channels = cmd.getChannels();
		
		// convert -1 .. 1 to values ranging between 1100 and 1900
		short t = (short)(1500+throttle*400);
		short y = (short)(1500+yaw*400);
		
		channels[0] = y;
		channels[2] = t;
		
		cmd.setChannels(channels);
		pRC.publish(cmd);
	}
	
	void sendCmd(short... channels){
		OverrideRCIn cmd = pRC.newMessage();	
		cmd.setChannels(channels);
		pRC.publish(cmd);
	}
}
