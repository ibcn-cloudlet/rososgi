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
package be.iminds.iot.robot.input.servlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.HttpService;

import be.iminds.iot.input.keyboard.api.KeyboardEvent;
import be.iminds.iot.input.keyboard.api.KeyboardEvent.Type;
import be.iminds.iot.input.keyboard.api.KeyboardListener;
import be.iminds.iot.robot.api.rover.Rover;

@Component( 
	    property = {"aiolos.proxy=false" }, 
		immediate = true)
public class KeyboardInputRover implements KeyboardListener {

	private Rover rover;
	
	private float throttle = 0;
	private float speed = 0.15f;
	private float yaw = 0;
	
	@Reference
	void setHttpService(HttpService http) {
		try {
			// TODO How to register resources with whiteboard pattern?
			http.registerResources("/robot", "res", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void onEvent(KeyboardEvent e){
		// control base
		if(e.type == Type.PRESSED){
			switch(e.key){
				case "ArrowUp":
				case "w":
					throttle = speed;
					rover.move(throttle, yaw);
					break;
				case "ArrowDown":
				case "s":
					throttle = -speed;
					rover.move(throttle, yaw);
					break;
				case "ArrowLeft":
				case "a":
					yaw = -1f;
					rover.move(throttle, yaw);
					break;
				case "ArrowRight":
				case "d":
					yaw = 1f;
					rover.move(throttle, yaw);
					break;
				case "p":
					speed += 0.05f;
					if(speed > 1){
						speed = 1;
					}
					System.out.println("Set speed "+speed);
					throttle = throttle > 0 ? speed : throttle < 0 ? -speed : 0;
					rover.move(throttle, yaw);
					break;
				case "l":
					speed -= 0.05f;
					if(speed < 0.15){
						speed = 0.15f;
					}
					System.out.println("Set speed "+speed);
					throttle = throttle > 0 ? speed : throttle < 0 ? -speed : 0;
					rover.move(throttle, yaw);
					break;					
			}
		} else if(e.type == Type.RELEASED){
			switch(e.key){
				case "ArrowUp":
				case "w":
				case "ArrowDown":
				case "s":
					throttle = 0;
					rover.move(throttle, yaw);
					break;
				case "ArrowLeft":
				case "a":
				case "ArrowRight":
				case "d":
					yaw = 0;
					rover.move(throttle, yaw);
					break;
			}
		}
	}

	
	@Reference
	void setRover(Rover rover){
		this.rover = rover;
	}

}
