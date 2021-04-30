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
package be.iminds.iot.ros.joystick;

import org.osgi.service.component.annotations.Component;

import be.iminds.iot.ros.util.NativeRosNode;

/**
 * Native ROS Joy node. Starts publishing Joy messages
 * 
 * @author tverbele
 *
 */
@Component(immediate=true)
public class JoyNode extends NativeRosNode {
	
	public JoyNode(){
		super("joy","joy_node");
	}
	
}

