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
package be.iminds.iot.robot.input.joy;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.input.joystick.api.JoystickEvent;
import be.iminds.iot.input.joystick.api.JoystickListener;
import be.iminds.iot.robot.api.rover.Rover;

@Component
public class JoystickInputRover implements JoystickListener {

	private Rover rover;
	
	@Override
	public void onEvent(JoystickEvent e) {
		
		switch(e.type){
		case JOYSTICK_CHANGED:
			float throttle = clamp(e.axes[1], -1f, 1f);
			float yaw = clamp(e.axes[2], -1f, 1f);
			rover.move(throttle, yaw);
			break;
		}
		
	}

	@Reference()
	void setRover(Rover rover){
		this.rover = rover;
	}

	private float clamp(float f, float low, float high){
		if(f < low)
			return low;
		else if(f > high)
			return high;
		return f;
	}
}
