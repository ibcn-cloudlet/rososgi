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

public class JointValue {

	public enum Type {
		POSITION,
		VELOCITY,
		TORQUE
	}
	
	public String joint;
	public Type type;
	public float value;
	
	public JointValue(String joint, Type t, float val){
		this.joint = joint;
		this.type = t;
		this.value = val;
	}
}
