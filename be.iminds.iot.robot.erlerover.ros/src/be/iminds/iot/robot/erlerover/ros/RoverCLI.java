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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.robot.api.rover.Rover;

@Component(service={Object.class},
	property = {"osgi.command.scope=rover", 
	"osgi.command.function=move",
	"osgi.command.function=halt",
	"osgi.command.function=cmd"})
public class RoverCLI {

	private Rover rover;
	
	public void move(float throttle, float yaw){
		rover.move(throttle, yaw);
	}
	
	public void halt(){
		rover.stop();
	}
	
	public void cmd(short... channels){
		((RoverImpl)rover).sendCmd(channels);
	}
	
	
	@Reference
	public void setRover(Rover r){
		this.rover = r;
	}
}
