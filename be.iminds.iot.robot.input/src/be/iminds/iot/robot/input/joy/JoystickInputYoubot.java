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
import be.iminds.iot.robot.api.omni.OmniDirectional;

@Component
public class JoystickInputYoubot implements JoystickListener {

	private Arm arm;
	private OmniDirectional base;	
	
	private float velocity = 0.2f;
	private float angular = 0.4f;

	@Override
	public void onEvent(JoystickEvent e) {
		
		switch(e.type){
		case BUTTON_L1_PRESSED:
			// grip action
			arm.openGripper()
				.then(p -> arm.setPositions(2.92f, 0.0f, 0.0f, 0.0f, 2.875f))
				.then(p -> arm.setPositions(2.92f, 1.76f, -1.37f, 2.55f))
				.then(p -> arm.closeGripper())
				.then(p -> arm.setPositions(0.01f, 0.8f))
				.then(p -> arm.setPositions(0.01f, 0.8f, -1f, 2.9f))
				.then(p -> arm.openGripper())
				.then(p -> arm.setPosition(1, -1.3f))
				.then(p -> arm.reset());
			break;
		case JOYSTICK_CHANGED:
			// move base
			float vx = e.axes[0]*velocity;
			float vy = e.axes[1]*velocity;
			float va = e.axes[2]*angular;
			
			base.move(vx, vy, va);
			break;
		}
		
	}

	@Reference
	void setArm(Arm arm){
		this.arm = arm;
	}
	
	@Reference
	void setBase(OmniDirectional base){
		this.base = base;
	}

}
