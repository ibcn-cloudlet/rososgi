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

public class JointDescription {

	public final String name;
	
	public final float positionMin;
	public final float positionMax;
	
	public final float velocityMin;
	public final float velocityMax;
	
	public final float torqueMin;
	public final float torqueMax;
	
	public JointDescription(String name,
			float pMin, float pMax,
			float vMin, float vMax,
			float tMin, float tMax){
		
		this.name = name;
		
		this.positionMin = pMin;
		this.positionMax = pMax;
		
		this.velocityMin = vMin;
		this.velocityMax = vMax;
		
		this.torqueMin = tMin;
		this.torqueMax = tMax;
	}
	
	public String getName(){
		return name;
	}
	
	public float getPositionMin(){
		return positionMin;
	}
	
	public float getPositionMax(){
		return positionMax;
	}
	
	public float getVelocityMin(){
		return velocityMin;
	}
	
	public float getVelocityMax(){
		return velocityMax;
	}
	
	public float getTorqueMin(){
		return torqueMin;
	}
	
	public float getTorqueMax(){
		return torqueMax;
	}
}
