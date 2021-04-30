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
package be.iminds.iot.robot.cli;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.robot.api.rover.Rover;

@Component(service={Object.class},
	property = {"osgi.command.scope=rover", 
	"osgi.command.function=move",
	"osgi.command.function=stop"
	})
public class RoverCLI {

	private Rover rover;
	
	public void move(float throttle, float yaw) {
		rover.move(throttle, yaw);
	}
	
	public void stop() {
		rover.stop();
	}
	
	@Reference
	void setRover(Rover r){
		this.rover = r;
	}
	
}
