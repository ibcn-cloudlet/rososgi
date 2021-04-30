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

public class JointState {

	public String joint;
	public float position;
	public float velocity;
	public float torque;
	
	public JointState(String joint, float p, float v, float t){
		this.joint = joint;
		this.position = p;
		this.velocity = v;
		this.torque = t;
	}
}
