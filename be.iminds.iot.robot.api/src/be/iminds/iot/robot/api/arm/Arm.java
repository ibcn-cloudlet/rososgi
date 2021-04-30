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
package be.iminds.iot.robot.api.arm;

import java.util.Collection;
import java.util.List;

import org.osgi.util.promise.Promise;

import be.iminds.iot.robot.api.JointDescription;
import be.iminds.iot.robot.api.JointState;
import be.iminds.iot.robot.api.JointValue;
import be.iminds.iot.robot.api.Pose;
import be.iminds.iot.robot.api.Robot;

public interface Arm extends Robot<Arm> {

	List<JointDescription> getJoints();
	
	List<JointState> getState();

	Pose getPose();
	
	
	float getSpeed();
	
	void setSpeed(float speed);
	
	Object getProperty(String property);
	
	void setProperty(String property, Object value);


	Promise<Arm> setPosition(int joint, float position);
	
	Promise<Arm> setVelocity(int joint, float velocity);

	Promise<Arm> setTorque(int joint, float torque);
	
	
	Promise<Arm> setPositions(float... position);
	
	Promise<Arm> setVelocities(float... velocity);

	Promise<Arm> setTorques(float... torque);


	Promise<Arm> openGripper();
	
	Promise<Arm> openGripper(float opening);
		
	Promise<Arm> closeGripper();
	
	Promise<Arm> closeGripper(float opening, float effort);

	boolean isGrasped();
	

	Promise<Arm> setPositions(Collection<JointValue> positions);
	
	Promise<Arm> setVelocities(Collection<JointValue> velocities);

	Promise<Arm> setTorques(Collection<JointValue> torques);
	

	Promise<Arm> reset();
	
	Promise<Arm> stop(int joint);
	
	Promise<Arm> recover();
	
	
	Promise<Arm> moveTo(float x, float y, float z);
	
	Promise<Arm> moveTo(float x, float y, float z, float ox, float oy, float oz, float ow);
	
	Promise<Arm> moveTo(Pose p);
	
	
	Promise<Arm> move(float vx, float vy, float vz);

	Promise<Arm> move(float vx, float vy, float vz, float ox, float oy, float oz);

	
	void guide();
}
