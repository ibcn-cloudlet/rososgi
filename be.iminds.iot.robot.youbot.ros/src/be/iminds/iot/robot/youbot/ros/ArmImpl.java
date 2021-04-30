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
package be.iminds.iot.robot.youbot.ros;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.promise.Deferred;
import org.osgi.util.promise.Promise;
import org.ros.exception.RemoteException;
import org.ros.exception.ServiceNotFoundException;
import org.ros.message.MessageFactory;
import org.ros.message.MessageListener;
import org.ros.node.ConnectedNode;
import org.ros.node.service.ServiceClient;
import org.ros.node.service.ServiceResponseListener;
import org.ros.node.topic.Publisher;
import org.ros.node.topic.Subscriber;

import be.iminds.iot.robot.api.Joint;
import be.iminds.iot.robot.api.JointDescription;
import be.iminds.iot.robot.api.JointState;
import be.iminds.iot.robot.api.JointValue;
import be.iminds.iot.robot.api.JointValue.Type;
import be.iminds.iot.robot.api.Pose;
import be.iminds.iot.robot.api.arm.Arm;
import be.iminds.iot.robot.api.arm.Gripper;
import ik_solver_service.SolvePreferredPitchIK;
import ik_solver_service.SolvePreferredPitchIKRequest;
import ik_solver_service.SolvePreferredPitchIKResponse;

public class ArmImpl implements Arm {

	private final String name;
	
	private final BundleContext context;
	private final List<ServiceRegistration<?>> registrations = new ArrayList<>();
	
	private final List<JointImpl> joints;
	private final Gripper gripper;
	
	
	private final ConnectedNode node;
	private final MessageFactory factory;
	private Publisher<brics_actuator.JointPositions> pPos;
	private Publisher<brics_actuator.JointVelocities> pVel;
	private Publisher<brics_actuator.JointTorques> pTorq;
	private Publisher<brics_actuator.JointPositions> pGrip;
	
	private Subscriber<sensor_msgs.JointState> subscriber; 

	private ServiceClient<SolvePreferredPitchIKRequest, SolvePreferredPitchIKResponse> ik;
	
	private final Map<Target, Deferred<Arm>> targets = new ConcurrentHashMap<>();
	// target threshold
	private static float THRESHOLD = 0.002f;

	
	private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
	// TODO get from config? also look at be.iminds.iot.ros.simulator.vrep.youbot.Youbot
	private String[] config = new String[]{
			"arm_joint_1",
			"arm_joint_2",
			"arm_joint_3",
			"arm_joint_4",
			"arm_joint_5",
			"gripper_finger_joint_l",
			"gripper_finger_joint_r"
	};
	
	private float[] positionMin = new float[]{
		0.0100693f, 
		0.0100693f, 
		-5.02654f,
		0.0221239f, 
		0.11062f, 
		0f,      
		0f	
	};
	
	private float[] positionMax = new float[]{
		5.84014f,
		2.61799f,
		-0.015708f, 
		3.4292f, 
		5.64159f, 
		0.0114f, 
		0.0114f	
	};
	
	private float[] torqueMin = new float[]{
		-17f, -17f, -8f, -2.7f, -1f, -1f, -1f	
	};
		
	private float[] torqueMax = new float[]{
		17f, 17f, 8f, 2.7f, 1f, 1f, 1f	
	};
	
	public ArmImpl(String name, BundleContext context,
			ConnectedNode node){
		this.name = name;
		this.context = context;
		this.node = node;
		
		this.factory = node.getTopicMessageFactory();

		String t = context.getProperty("be.iminds.iot.robot.youbot.joint.threshold");
		if(t != null){
			THRESHOLD = Float.parseFloat(t);
		}
		
		// joints
		joints = new ArrayList<>();
		for(int i=0;i<config.length;i++){
			String jointName = config[i];
			JointDescription d = new JointDescription(jointName,
					positionMin[i], positionMax[i], 
					-1.57f, 1.57f, torqueMin[i], torqueMax[i]); // TODO what are min and max velocities? Pi/2?
			JointImpl joint = new JointImpl(d, this);
			joints.add(joint);
		}
		
		// gripper
		gripper = new Gripper() {
			
			@Override
			public void open() {
				openGripper(0.02f);
			}
			
			@Override
			public void open(float opening) {
				openGripper(opening);
			}
			
			@Override
			public void close() {
				closeGripper();
			}

			@Override
			public void close(float opening, float effort) {
				closeGripper(); // we cannot control opening/effort
			}

			@Override
			public boolean isGrasped() {
				throw new UnsupportedOperationException("Grasp check not supported for Youbot...");
			}
		};
	}
	
	public void register(){
		// commands for arm joints
		this.pPos = node.newPublisher("/arm_1/arm_controller/position_command", brics_actuator.JointPositions._TYPE);
		this.pVel = node.newPublisher("/arm_1/arm_controller/velocity_command", brics_actuator.JointVelocities._TYPE);;
		this.pTorq = node.newPublisher("/arm_1/arm_controller/torque_command", brics_actuator.JointTorques._TYPE);;
		
		// commands for gripper joints
		this.pGrip = node.newPublisher("/arm_1/gripper_controller/position_command", brics_actuator.JointPositions._TYPE);
		
		// add subscriber
		subscriber = node.newSubscriber("/joint_states",
				sensor_msgs.JointState._TYPE);
		subscriber.addMessageListener(new MessageListener<sensor_msgs.JointState>() {
			@Override
			public void onNewMessage(sensor_msgs.JointState jointState) {
				// update JointImpl internal state1
				for(int i=0;i<jointState.getName().size();i++){
					String name = jointState.getName().get(i);
					JointImpl joint = getJoint(name);
					if(joint==null){
						continue;
					}
					
					joint.position = (float)jointState.getPosition()[i];
					joint.velocity = (float)jointState.getVelocity()[i];
					if(jointState.getEffort().length > i)
						joint.torque = (float)jointState.getEffort()[i];
				}
				
				// check if target is resolved 
				Iterator<Entry<Target, Deferred<Arm>>> it = targets.entrySet().iterator();
				while(it.hasNext()){
					Entry<Target, Deferred<Arm>> e = it.next();
					Target target = e.getKey();
					if(target.isResolved()){
						Deferred<Arm> d = e.getValue();
						if(d!=null){
							try {
								d.resolve(ArmImpl.this);
							} catch(IllegalStateException ex){}
						}
						it.remove();
					}
				}
			}
		});
		
		try {
		     ik = node.newServiceClient("/solve_ik_server/solve_preferred_pitch_ik", SolvePreferredPitchIK._TYPE);
		} catch(Exception e){
			// do nothing ... moveTo method will just fail when no ik service present
		}
		
		// register OSGi services
		for(Joint joint : joints){
			Dictionary<String, Object> properties = new Hashtable<>();
			properties.put("joint.name", joint.getName());
			ServiceRegistration<Joint> rJoint = context.registerService(Joint.class, joint, properties);
			registrations.add(rJoint);
		}	
		
		Dictionary<String, Object> properties = new Hashtable<>();
		properties.put("name", name);
		ServiceRegistration<Gripper> rGripper = context.registerService(Gripper.class, gripper, properties);
		registrations.add(rGripper);
		ServiceRegistration<Arm> rArm = context.registerService(Arm.class, this, properties);
		registrations.add(rArm);
	}
	
	public void unregister(){
		for(ServiceRegistration<?> r : registrations){
			r.unregister();
		}
		registrations.clear();
		
		pGrip.shutdown();
		pPos.shutdown();
		pVel.shutdown();
		pTorq.shutdown();
		subscriber.shutdown();
	}
	
	@Override
	public List<JointDescription> getJoints() {
		return joints.stream().map(j -> j.getDescription()).collect(Collectors.toList());
	}

	@Override
	public List<JointState> getState() {
		return joints.stream().map(j -> j.getState()).collect(Collectors.toList());
	}

	@Override
	public Promise<Arm> setPosition(int joint, float position){
		return setPositions(Collections.singleton(new JointValue(config[joint], Type.POSITION, position)));
	}
	
	@Override
	public Promise<Arm> setVelocity(int joint, float velocity){
		return setVelocities(Collections.singleton(new JointValue(config[joint], Type.VELOCITY, velocity)));
	}

	@Override
	public Promise<Arm> setTorque(int joint, float torque){
		return setTorques(Collections.singleton(new JointValue(config[joint], Type.TORQUE, torque)));
	}
	
	@Override
	public Promise<Arm> setPositions(Collection<JointValue> positions) {
		// check for collision with operations in progress
		for(JointValue v : positions){
			Iterator<Entry<Target, Deferred<Arm>>> it = targets.entrySet().iterator();
			while(it.hasNext()){
				Entry<Target, Deferred<Arm>> target = it.next();
				for(JointValue joint : target.getKey().target){
					if(joint.joint.equals(v.joint)){
						Deferred<Arm> deferred = target.getValue();
						try {
							deferred.fail(new Exception("Operation interrupted!"));
						} catch(IllegalStateException ex){}
						it.remove();
					}
				}
			}
		}
		Deferred<Arm> deferred = new Deferred<Arm>();
		Target target = new Target(positions);
		targets.put(target, deferred);

		boolean arm = false;
		boolean gripper = false;
		brics_actuator.JointPositions msg = pPos.newMessage();
		List<brics_actuator.JointValue> pp = new ArrayList<>();
		for(JointValue position : positions){
			brics_actuator.JointValue pos = factory.newFromType(brics_actuator.JointValue._TYPE);
			
			if(position.joint.startsWith("arm")){
				arm = true;
				pos.setUnit("rad");
			}
			if(position.joint.startsWith("gripper")){
				gripper = true;
				pos.setUnit("m");
			}
			
			pos.setJointUri(position.joint);
			
			JointDescription d = getJoint(position.joint).getDescription();
			position.value = clamp(position.value, d.positionMin, d.positionMax);
			pos.setValue(position.value);
			pp.add(pos);
		}
		msg.setPositions(pp);
				
		if(arm)
			pPos.publish(msg);
		if(gripper)
			pGrip.publish(msg);
		
		
		return deferred.getPromise();
	}

	@Override
	public Promise<Arm> setVelocities(Collection<JointValue> velocities) {
		// check for collision with operations in progress
		for(JointValue v : velocities){
			Iterator<Entry<Target, Deferred<Arm>>> it = targets.entrySet().iterator();
			while(it.hasNext()){
				Entry<Target, Deferred<Arm>> target = it.next();
				for(JointValue joint : target.getKey().target){
					if(joint.joint.equals(v.joint)){
						Deferred<Arm> deferred = target.getValue();
						try {
							deferred.fail(new Exception("Operation interrupted!"));
						} catch(IllegalStateException ex){}
						it.remove();
					}
				}
			}
		}
		Deferred<Arm> deferred = new Deferred<Arm>();
		Target target = new Target(velocities);
		targets.put(target, deferred);

		brics_actuator.JointVelocities msg = pVel.newMessage();
		List<brics_actuator.JointValue> vv = new ArrayList<>();
		for(JointValue velocity : velocities){
			brics_actuator.JointValue vel = factory.newFromType(brics_actuator.JointValue._TYPE);
			vel.setJointUri(velocity.joint);
			vel.setUnit("s^-1 rad");
			
			JointDescription d = getJoint(velocity.joint).getDescription();
			velocity.value = clamp(velocity.value, d.velocityMin, d.velocityMax);
			vel.setValue(velocity.value);
			vv.add(vel);
		}
		msg.setVelocities(vv);
		pVel.publish(msg);
		
		return deferred.getPromise();
	}

	@Override
	public Promise<Arm> setTorques(Collection<JointValue> torques) {
		
		// check for collision with operations in progress
		for(JointValue v : torques){
			Iterator<Entry<Target, Deferred<Arm>>> it = targets.entrySet().iterator();
			while(it.hasNext()){
				Entry<Target, Deferred<Arm>> target = it.next();
				for(JointValue joint : target.getKey().target){
					if(joint.joint.equals(v.joint)){
						Deferred<Arm> deferred = target.getValue();
						try {		
							deferred.fail(new Exception("Operation interrupted!"));
						} catch(IllegalStateException ex){}
						it.remove();
					}
				}
			}
		}
		Deferred<Arm> deferred = new Deferred<Arm>();
		// TODO ... should we wait or immediately resolve?
		deferred.resolve(this);
//		Target target = new Target(torques);
//		targets.put(target, deferred);

		brics_actuator.JointTorques msg = pTorq.newMessage();
		List<brics_actuator.JointValue> tt = new ArrayList<>();
		for(JointValue torque : torques){
			brics_actuator.JointValue tor = factory.newFromType(brics_actuator.JointValue._TYPE);
			tor.setJointUri(torque.joint);
			tor.setUnit("m^2 kg s^-2 rad^-1");
		
			JointDescription d = getJoint(torque.joint).getDescription();
			torque.value = clamp(torque.value, d.torqueMin, d.torqueMax);
			tor.setValue(torque.value);
			tt.add(tor);
		}
		msg.setTorques(tt);
		pTorq.publish(msg);

		return deferred.getPromise();
	}

	
	// open and closed is inverted when using festo finger grippers :-)
	@Override
	public Promise<Arm> openGripper() {
		 return openGripper(0);
	}
	
	@Override
	public Promise<Arm> openGripper(float opening) {
		List<JointValue> positions = new ArrayList<>();
		positions.add(new JointValue(config[5], Type.POSITION, opening/2));
		positions.add(new JointValue(config[6], Type.POSITION, opening/2));
		return setPositions(positions);
	}

	@Override
	public Promise<Arm> closeGripper(float opening, float effort) {
		return closeGripper();
	}
	
	@Override
	public Promise<Arm> closeGripper() {
		openGripper(positionMax[5]*2);
		// TODO this is a hack to make it work in simulation 
		// where the end positions are not reached during grabbing
		return waitFor(2000);
	}

	@Override
	public boolean isGrasped() {
		return gripper.isGrasped();
	}
	
	@Override
	public Promise<Arm> setPositions(float... position) {
		List<JointValue> jointValues = new ArrayList<>();
		for(int i=0;i<position.length;i++){
			JointValue val = new JointValue(joints.get(i).getName(), Type.POSITION, position[i]);
			jointValues.add(val);
		}
		return setPositions(jointValues);
	}

	@Override
	public Promise<Arm> setVelocities(float... velocity) {
		List<JointValue> jointValues = new ArrayList<>();
		for(int i=0;i<velocity.length;i++){
			JointValue val = new JointValue(joints.get(i).getName(), Type.VELOCITY, velocity[i]);
			jointValues.add(val);
		}
		return setVelocities(jointValues);
	}

	@Override
	public Promise<Arm> setTorques(float... torque) {
		List<JointValue> jointValues = new ArrayList<>();
		for(int i=0;i<torque.length;i++){
			JointValue val = new JointValue(joints.get(i).getName(), Type.TORQUE, torque[i]);
			jointValues.add(val);
		}
		return setTorques(jointValues);
	}

	@Override
	public Promise<Arm> waitFor(long time) {
		Deferred<Arm> deferred = new Deferred<Arm>();
		executor.schedule(new ResolveTask(deferred), time, TimeUnit.MILLISECONDS);
		return deferred.getPromise();
	}
	
	@Override
	public Promise<Arm> reset() {
		return setPositions(0.0f, 0.0f, 0.0f, 0.0f, 0.0f).then(p -> closeGripper());
	}
	
	private class ResolveTask implements Runnable {
		
		private Deferred<Arm> deferred;
		
		public ResolveTask(Deferred<Arm> deferred){
			this.deferred = deferred;
		}
		
		@Override
		public void run() {
			try {
				deferred.resolve(ArmImpl.this);
			} catch(IllegalStateException e){
				// ignore if already resolved
			}
		}
	}
	
	@Override
	public Promise<Arm> stop() {
		// TODO should we power off the motors?

		// set all joints to current position
		return setPositions(getState().stream()
				.map(s -> new JointValue(s.joint, Type.POSITION, s.position))
				.collect(Collectors.toList()));
	}

	
	@Override
	public Promise<Arm> stop(int joint) {
		return setPosition(joint, getState().get(joint).position);
	}
	
	@Override
	public Promise<Arm> moveTo(float x, float y, float z) {
		Deferred<Arm> deferred = new Deferred<>();
		
		if(ik == null){
			try {
			     ik = node.newServiceClient("/solve_ik_server/solve_preferred_pitch_ik", SolvePreferredPitchIK._TYPE);
			} catch(ServiceNotFoundException e){
				deferred.fail(e);
				return deferred.getPromise();
			}
		}

		final SolvePreferredPitchIKRequest request = ik.newMessage();
		request.setPreferredPitch(3*Math.PI/4);
		request.setDesNormal(new double[]{-y, x, 0});
		request.setDesPosition(new double[]{x, y, z});
		ik.call(request, new ServiceResponseListener<SolvePreferredPitchIKResponse>() {
			
			@Override
			public void onSuccess(SolvePreferredPitchIKResponse response) {
//				System.out.println("Solution");
//				System.out.println("Feasible "+response.getFeasible());
//				System.out.println("Arm bend up "+response.getArmBendedUp());
//				System.out.println("Arm to front "+response.getArmToFront());
//				System.out.println("Gripper downwards "+response.getGripperDownwards());
//				System.out.println("Angles "+Arrays.toString(response.getJointAngles()));
				
				if(!response.getFeasible()){
					deferred.fail(new RuntimeException("The requested trajectory is not feasible"));
					return;
				}
				
				double[] jointPositions = response.getJointAngles();
				deferred.resolveWith(setPositions((float)jointPositions[0],(float)jointPositions[1],
						(float)jointPositions[2],(float)jointPositions[3], joints.get(4).position));
			}
			
			@Override
			public void onFailure(RemoteException ex) {
				ex.printStackTrace();
				deferred.fail(ex);
			}
		});
		
		return deferred.getPromise();
	}
	
	private class Target {
		
		final Collection<JointValue> target;
		
		public Target(Collection<JointValue> states){
			this.target = states;
		}
		
		public boolean isResolved(){
			for(JointValue v : target){
				Joint joint = getJoint(v.joint);
				if(joint==null)
					return false;
				
				switch(v.type){
				case POSITION:
					if(Math.abs(joint.getPosition()-v.value) > THRESHOLD){
						return false;
					}
					break;
				case VELOCITY:
					if(Math.abs(joint.getVelocity()-v.value) > THRESHOLD){
						return false;
					}
					break;
				case TORQUE:
					if(Math.abs(joint.getTorque()-v.value) > THRESHOLD){
						return false;
					}
					break;
				}
			}
			return true;
		}
	}
	
	private JointImpl getJoint(String name){
		try {
			return joints.stream().filter(j -> j.getName().equals(name)).findFirst().get();
		} catch(NoSuchElementException e){
			return null;
		}
	}

	private float clamp(float value, float min, float max){
		if(value < min){
			return min;
		} else if(value > max){
			return max;
		}
		return value;
	}

	@Override
	public Pose getPose() {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getSpeed() {
		return 1;
	}

	@Override
	public void setSpeed(float speed) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getProperty(String property) {
		return null;
	}

	@Override
	public void setProperty(String property, Object value) {
	}

	@Override
	public Promise<Arm> recover() {
		return stop();
	}

	@Override
	public Promise<Arm> moveTo(float x, float y, float z, float ox, float oy, float oz, float ow) {
		return moveTo(x, y, z);
	}

	@Override
	public Promise<Arm> moveTo(Pose p) {
		return moveTo(p.position.x, p.position.y, p.position.z);
	}
	
	@Override
	public Promise<Arm> move(float vx, float vy, float vz) {
		throw new UnsupportedOperationException("Cartesian velocity control not supported");
	}

	@Override
	public Promise<Arm> move(float vx, float vy, float vz, float ox, float oy, float oz) {
		throw new UnsupportedOperationException("Cartesian velocity control not supported");
	}

	@Override
	public void guide() {
		throw new UnsupportedOperationException("Youbot does not support guide mode");
	}

}
