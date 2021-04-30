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
package be.iminds.iot.robot.api;

import be.iminds.iot.robot.api.JointDescription;
import be.iminds.iot.robot.api.JointState;

public interface Joint {

	String getName();
	
	JointDescription getDescription();
	
	void setPosition(float p);
	
	float getPosition();
	
	void setVelocity(float v);
	
	float getVelocity();
	
	void setTorque(float t);
	
	float getTorque();
	
	JointState getState();
	
}
