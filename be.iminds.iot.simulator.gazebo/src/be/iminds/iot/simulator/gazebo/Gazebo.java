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

import java.io.File;
import java.nio.file.Files;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.osgi.util.promise.Deferred;
import org.osgi.util.promise.Promise;
import org.ros.exception.RemoteException;
import org.ros.message.MessageListener;
import org.ros.message.Time;
import org.ros.node.ConnectedNode;
import org.ros.node.service.ServiceClient;
import org.ros.node.service.ServiceResponseListener;
import org.ros.node.topic.Subscriber;

import be.iminds.iot.simulator.api.Orientation;
import be.iminds.iot.simulator.api.Position;
import be.iminds.iot.simulator.api.Simulator;
import gazebo_msgs.DeleteModelRequest;
import gazebo_msgs.DeleteModelResponse;
import gazebo_msgs.GetModelStateRequest;
import gazebo_msgs.GetModelStateResponse;
import gazebo_msgs.ModelState;
import gazebo_msgs.SetModelStateRequest;
import gazebo_msgs.SetModelStateResponse;
import gazebo_msgs.SpawnModelRequest;
import gazebo_msgs.SpawnModelResponse;
import geometry_msgs.Point;
import geometry_msgs.Pose;
import geometry_msgs.Quaternion;
import rosgraph_msgs.Clock;
import std_srvs.EmptyResponse;

/**
 * Simulator implementation for the Gazebo simulator
 * 
 * @author tverbele
 *
 */
public class Gazebo implements Simulator {
	
	private ServiceClient<std_srvs.EmptyRequest, std_srvs.EmptyResponse> start;
	private ServiceClient<std_srvs.EmptyRequest, std_srvs.EmptyResponse> stop;
	private ServiceClient<std_srvs.EmptyRequest, std_srvs.EmptyResponse> resetWorld;
	private ServiceClient<gazebo_msgs.SpawnModelRequest, gazebo_msgs.SpawnModelResponse> spawnSDFModel;
	private ServiceClient<gazebo_msgs.SpawnModelRequest, gazebo_msgs.SpawnModelResponse> spawnURDFModel;
	private ServiceClient<gazebo_msgs.SpawnModelRequest, gazebo_msgs.SpawnModelResponse> spawnGazeboModel;
	private ServiceClient<gazebo_msgs.DeleteModelRequest, gazebo_msgs.DeleteModelResponse> deleteModel;
	private ServiceClient<gazebo_msgs.GetModelStateRequest, gazebo_msgs.GetModelStateResponse> getModelState;
	private ServiceClient<gazebo_msgs.SetModelStateRequest, gazebo_msgs.SetModelStateResponse> setModelState;

	private Subscriber<rosgraph_msgs.Clock> clock; 

	private volatile boolean running = false;
	private volatile boolean sync = false;
	private Object lock = new Object();
	
	private long millis = 0;
	private long step;
	
	private volatile String scene = null;
	
	public Gazebo(ConnectedNode node) throws Exception{
		start = node.newServiceClient("/gazebo/unpause_physics", std_srvs.Empty._TYPE);
		stop = node.newServiceClient("/gazebo/pause_physics",  std_srvs.Empty._TYPE);
		resetWorld = node.newServiceClient("/gazebo/reset_world",  std_srvs.Empty._TYPE);
		spawnSDFModel = node.newServiceClient("/gazebo/spawn_sdf_model", gazebo_msgs.SpawnModel._TYPE);
		spawnURDFModel = node.newServiceClient("/gazebo/spawn_urdf_model", gazebo_msgs.SpawnModel._TYPE);
		spawnGazeboModel = node.newServiceClient("/gazebo/spawn_gazebo_model", gazebo_msgs.SpawnModel._TYPE);
		deleteModel = node.newServiceClient("/gazebo/delete_model", gazebo_msgs.DeleteModel._TYPE);
		getModelState = node.newServiceClient("/gazebo/get_model_state", gazebo_msgs.GetModelState._TYPE);
		setModelState = node.newServiceClient("/gazebo/set_model_state", gazebo_msgs.SetModelState._TYPE);

		
		clock = node.newSubscriber("/clock", rosgraph_msgs.Clock._TYPE);
		clock.addMessageListener(new MessageListener<rosgraph_msgs.Clock>() {
			@Override
			public void onNewMessage(Clock c) {
				if(sync && c.getClock().compareTo(new Time((int)(millis / 1000), (int)((millis % 1000)*1000000))) >= 0){
					synchronized(lock){
						pause();
						millis = c.getClock().totalNsecs()/1000000;
						lock.notifyAll();
					}
				}
			}
		});
	}
	
	@Override
	public synchronized void start(boolean s, float step, Map<String, Object> config) {
		this.step = (long)(step*1000);
		this.running = true;
		this.sync = s;
		unpause();
	}
	
	private synchronized void unpause(){
		final Deferred<Void> deferred = new Deferred<>();
		start.call(start.newMessage(), new ServiceResponseListener<EmptyResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				deferred.fail(ex);
			}
			@Override
			public void onSuccess(EmptyResponse arg0) {
				deferred.resolve(null);
			}
		});
		try {
			deferred.getPromise().getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void pause() {
		final Deferred<Void> deferred = new Deferred<>();
		stop.call(stop.newMessage(), new ServiceResponseListener<EmptyResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				deferred.fail(ex);
			}
			@Override
			public void onSuccess(EmptyResponse arg0) {
				deferred.resolve(null);
			}
		});
		try {
			deferred.getPromise().getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void resume(){
		unpause();
	}

	@Override
	public synchronized void stop() {
		running = false;
		final Deferred<Void> deferred = new Deferred<>();
		stop.call(stop.newMessage(), new ServiceResponseListener<EmptyResponse>() {
			@Override
			public void onSuccess(EmptyResponse paramMessageType) {
				resetWorld.call(resetWorld.newMessage(), new ServiceResponseListener<EmptyResponse>() {
					@Override
					public void onSuccess(EmptyResponse paramMessageType) {
						deferred.resolve(null);
					}
					@Override
					public void onFailure(RemoteException ex) {
						deferred.fail(ex);
					}
				});
			}
			@Override
			public void onFailure(RemoteException ex) {
				deferred.fail(ex);
			}
		});
		try {
			deferred.getPromise().getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() throws TimeoutException {
		if(running){
			synchronized(lock){
				millis += step;
				unpause();
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	@Override
	public void loadScene(String file, Map<String, String> config) {
		// in case of gazebo we see the "scene" as a single model that can be loaded
		// if we load a new scene, we first delete the previous "scene" 
		
		if(scene != null){
			try {
				deleteModel(scene).getValue();
			} catch (Exception e) {
			}
		}
		
		Position position = null;
		Orientation orientation = null;
	
		if(config.containsKey("pose")){
			String pose = config.get("pose");
			String[] numbers = pose.split(",");
			if(numbers.length >= 3){
				position = new Position();
				position.x = Float.parseFloat(numbers[0].trim());
				position.y = Float.parseFloat(numbers[1].trim());
				position.z = Float.parseFloat(numbers[2].trim());
			} 
			if(numbers.length == 6){
				orientation = new Orientation();
				orientation.alfa = Float.parseFloat(numbers[3].trim());
				orientation.beta = Float.parseFloat(numbers[4].trim());
				orientation.gamma = Float.parseFloat(numbers[5].trim());
			}
		}			
			
		try {
			spawnModel(file, position, orientation).getValue();
		} catch (Exception e) {
		}
	
	}
	
	private Promise<Void> spawnModel(String file, Position position, Orientation orientation){
		ServiceClient<SpawnModelRequest, SpawnModelResponse> spawnModel = null;
		if(file.endsWith(".sdf")){
			spawnModel = spawnSDFModel;
		} else if(file.endsWith(".urdf")){
			spawnModel = spawnURDFModel;
		} else {
			spawnModel = spawnGazeboModel;
		}

		final Deferred<Void> deferred = new Deferred<>();
			
		try {
			File f = new File(file);
			byte[] bytes = Files.readAllBytes(f.toPath());
			String xml = new String(bytes);
			
			SpawnModelRequest req = spawnModel.newMessage();
			final String name = f.getName();
			req.setModelName(name);
			req.setModelXml(xml);
			Pose p = req.getInitialPose();

			if(position != null){
				Point point = p.getPosition();
				point.setX(position.x);
				point.setY(position.y);
				point.setZ(position.z);
				p.setPosition(point);
			}
			
			if(orientation != null){
				Quaternion q = p.getOrientation();
				orientationToQuaternion(orientation, q);
				p.setOrientation(q);
			}
			
			req.setInitialPose(p);

			spawnModel.call(req, new ServiceResponseListener<SpawnModelResponse>() {
				@Override
				public void onFailure(RemoteException ex) {
					deferred.fail(ex);
				}

				@Override
				public void onSuccess(SpawnModelResponse resp) {
					if(resp.getSuccess()){
						Gazebo.this.scene = name;
						deferred.resolve(null);
					} else {
						deferred.fail(new Exception(resp.getStatusMessage()));
					}
				}
			});
		} catch(Exception e){
			deferred.fail(e);
		}
		
		return deferred.getPromise();
	}
	
	private Promise<Void> deleteModel(String modelName){
		final Deferred<Void> deferred = new Deferred<>();
		
		DeleteModelRequest req = deleteModel.newMessage();
		req.setModelName(modelName);
		
		deleteModel.call(req, new ServiceResponseListener<DeleteModelResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				deferred.fail(ex);
			}

			@Override
			public void onSuccess(DeleteModelResponse resp) {
				if(resp.getSuccess()){
					deferred.resolve(null);
				} else {
					deferred.fail(new Exception(resp.getStatusMessage()));
				}
			}
		});
		
		return deferred.getPromise();
	}

	@Override
	public Position getPosition(String object) {
		return getPosition(object, null);
	}

	@Override
	public void setPosition(String object, Position p) {
		setPosition(object, null, p);
	}

	@Override
	public Position getPosition(String object, String relativeTo) {
		Pose pose;
		try {
			pose = getPose(object, relativeTo).getValue();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get position for object "+object, e);
		}
		Position position = new Position(
				(float)pose.getPosition().getX(), 
				(float)pose.getPosition().getY(), 
				(float)pose.getPosition().getZ());
		return position;
	}

	@Override
	public void setPosition(String object, String relativeTo, Position p) {
		try {
			if(relativeTo == null){
				relativeTo = "world";
			}
			
			Pose pose = getPose(object, relativeTo).getValue();
			
			Point point = pose.getPosition();
			point.setX(p.x);
			point.setY(p.y);
			point.setZ(p.z);
			pose.setPosition(point);
			
			setPose(object, relativeTo, pose).getValue();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get position for object "+object, e);
		}
	}
		
	public void setPosition(String object, float x, float y, float z) {
		setPosition(object, null, new Position(x,y,z));
	}
	
	public void setPosition(String object, String relativeTo, float x, float y, float z) {
		setPosition(object, relativeTo, new Position(x,y,z));
	}
	
	@Override
	public Orientation getOrientation(String object) {
		return getOrientation(object, null);
	}

	@Override
	public void setOrientation(String object, Orientation o) {
		setOrientation(object, null, o);
	}

	@Override
	public Orientation getOrientation(String object, String relativeTo) {
		Pose pose;
		try {
			pose = getPose(object, relativeTo).getValue();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get position for object "+object, e);
		}
		Orientation orientation = new Orientation();
		quaternionToOrientation(pose.getOrientation(), orientation);
		return orientation;
	}

	@Override
	public void setOrientation(String object, String relativeTo, Orientation o) {
		try {
			if(relativeTo == null){
				relativeTo = "world";
			}
			
			Pose pose = getPose(object, relativeTo).getValue();
			
			Quaternion q = pose.getOrientation();
			orientationToQuaternion(o, q);
			pose.setOrientation(q);
			
			setPose(object, relativeTo, pose).getValue();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get position for object "+object, e);
		}
	}
	
	public void setOrientation(String object, float a, float b, float g) {
		setOrientation(object, new Orientation(a,b,g));
	}
	
	public void setOrientation(String object, String relativeTo, float a, float b, float g) {
		setOrientation(object, relativeTo, new Orientation(a,b,g));
	}
	
	@Override
	public void setPose(String object, Position p, Orientation o) {
		setPose(object, null, p, o);
	}

	@Override
	public void setPose(String object, String relativeTo, Position p, Orientation o) {
		try {
			if(relativeTo == null){
				relativeTo = "world";
			}
			
			Pose pose = getPose(object, relativeTo).getValue();
			
			Point point = pose.getPosition();
			point.setX(p.x);
			point.setY(p.y);
			point.setZ(p.z);
			pose.setPosition(point);
			
			Quaternion q = pose.getOrientation();
			orientationToQuaternion(o, q);
			pose.setOrientation(q);
			
			setPose(object, relativeTo, pose).getValue();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get position for object "+object, e);
		}
	}
	
	private Promise<Pose> getPose(String object, String relativeTo){
		final Deferred<Pose> deferred = new Deferred<>();
		
		GetModelStateRequest req = getModelState.newMessage();
		req.setModelName(object);
		if(relativeTo == null){
			relativeTo = "world";
		}
		req.setRelativeEntityName(relativeTo);
		
		getModelState.call(req, new ServiceResponseListener<GetModelStateResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				deferred.fail(ex);
			}

			@Override
			public void onSuccess(GetModelStateResponse resp) {
				if(resp.getSuccess()){
					deferred.resolve(resp.getPose());
				} else {
					deferred.fail(new Exception(resp.getStatusMessage()));
				}
			}
		});
		
		return deferred.getPromise();
	}
	
	private Promise<Void> setPose(String object, String relativeTo, Pose pose){
		final Deferred<Void> deferred = new Deferred<>();
		
		SetModelStateRequest req = setModelState.newMessage();
		ModelState state = req.getModelState();
		state.setModelName(object);
		state.setReferenceFrame(relativeTo);
		state.setPose(pose);
		
		setModelState.call(req, new ServiceResponseListener<SetModelStateResponse>() {
			@Override
			public void onFailure(RemoteException ex) {
				deferred.fail(ex);
			}

			@Override
			public void onSuccess(SetModelStateResponse resp) {
				if(resp.getSuccess()){
					deferred.resolve(null);
				} else {
					deferred.fail(new Exception(resp.getStatusMessage()));
				}
			}
		});
		
		return deferred.getPromise();
	}
	

	@Override
	public boolean checkCollisions(String object) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setProperty(String key, Object value){
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Object getProperty(String key){
		throw new UnsupportedOperationException();
	}
	
	private void quaternionToOrientation(Quaternion q, Orientation o){
		double ysqr = q.getY() * q.getY();

		// roll (x-axis rotation)
		double t0 = +2.0 * (q.getW() * q.getX() + q.getY() * q.getZ());
		double t1 = +1.0 - 2.0 * (q.getX() * q.getX() + ysqr);
		double roll = Math.atan2(t0, t1);

		// pitch (y-axis rotation)
		double t2 = +2.0 * (q.getW() * q.getY() - q.getZ() * q.getX());
		t2 = t2 > 1.0 ? 1.0 : t2;
		t2 = t2 < -1.0 ? -1.0 : t2;
		double pitch = Math.asin(t2);

		// yaw (z-axis rotation)
		double t3 = +2.0 * (q.getW() * q.getZ() + q.getX() * q.getY());
		double t4 = +1.0 - 2.0 * (ysqr + q.getZ() * q.getZ());  
		double yaw = Math.atan2(t3, t4);
		
		o.alfa = (float)roll;
		o.beta = (float)pitch;
		o.gamma = (float)yaw;
	}
	
	private void orientationToQuaternion(Orientation o, Quaternion q){
		// Converting euler angles to quaternion
		// Assuming euler angles in radians!
		double t0 = Math.cos(o.gamma * 0.5);
		double t1 = Math.sin(o.gamma * 0.5);
		double t2 = Math.cos(o.alfa * 0.5);
		double t3 = Math.sin(o.alfa * 0.5);
		double t4 = Math.cos(o.beta * 0.5);
		double t5 = Math.sin(o.beta * 0.5);

		double w = t0 * t2 * t4 + t1 * t3 * t5;
		double x = t0 * t3 * t4 - t1 * t2 * t5;
		double y = t0 * t2 * t5 + t1 * t3 * t4;
		double z = t1 * t2 * t4 - t0 * t3 * t5;
		
		q.setW(w);
		q.setX(x);
		q.setY(y);
		q.setZ(z);
	}

}
