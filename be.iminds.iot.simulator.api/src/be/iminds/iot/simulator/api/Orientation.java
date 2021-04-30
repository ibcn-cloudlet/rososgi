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
package be.iminds.iot.simulator.api;

public class Orientation {

	public float alfa;
	public float beta;
	public float gamma;
	
	public Orientation(){}
	
	public Orientation(float alfa, float beta, float gamma){
		this.alfa = alfa;
		this.beta = beta;
		this.gamma = gamma;
	}
	
	public String toString(){
		return "["+alfa+","+beta+","+gamma+"]";
	}
}
