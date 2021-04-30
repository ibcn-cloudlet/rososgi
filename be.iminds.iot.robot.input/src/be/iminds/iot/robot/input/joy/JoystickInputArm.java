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
import be.iminds.iot.robot.api.arm.Arm;

@Component
public class JoystickInputArm implements JoystickListener {

	private Arm arm;
	
	private float velocity = 0.1f;
	private float angular = 0.5f;

	@Override
	public void onEvent(JoystickEvent e) {
		switch(e.type){
		case BUTTON_R1_PRESSED:
			arm.openGripper();
			break;
		case BUTTON_R2_PRESSED:
			arm.closeGripper();
			break;	
		case BUTTON_START_PRESSED:
			arm.recover();
			break;
		case BUTTON_SELECT_PRESSED:
			arm.stop();
			break;	
		case JOYSTICK_CHANGED:
			float vx = -e.axes[1]*velocity;
			float vy = -e.axes[0]*velocity;
			float vz = e.axes[3]*velocity;
			float va = e.axes[2]*angular;
			
			arm.move(vx, vy, vz, 0, 0, va);
			break;
		}
	}

	@Reference
	void setArm(Arm arm){
		this.arm = arm;
	}
}
