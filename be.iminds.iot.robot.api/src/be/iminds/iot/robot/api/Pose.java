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

public class Pose {

	public Position position;
	public Orientation orientation;
	
	public Pose() {
		this.position = new Position();
		this.orientation = new Orientation();
	}
	
	public Pose(Position p, Orientation o) {
		this.position = p;
		this.orientation = o;
	}
	
	public Pose(float x, float y, float z, float ox, float oy, float oz, float ow) {
		this.position = new Position(x,y,z);
		this.orientation = new Orientation(ox,oy,oz,ow);
	}
	
	@Override
	public String toString() {
		return position.toString()+" "+orientation.toString();
		
	}
}
