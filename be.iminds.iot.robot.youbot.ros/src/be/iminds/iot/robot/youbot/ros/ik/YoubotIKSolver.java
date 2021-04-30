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
package be.iminds.iot.robot.youbot.ros.ik;

import org.osgi.service.component.annotations.Component;

import be.iminds.iot.ros.util.NativeRosNode;

@Component(immediate=true,
	property={
			"lox=0.033",
			"loz=0.246",  // move z to ground plane of mobile base
			"l2=0.155",
			"l3=0.135",
			"l4=0.316", // tip of festo gripper
	})
public class YoubotIKSolver extends NativeRosNode {

	public YoubotIKSolver(){
		super("ik_solver_service","ik_solver_service");
	}
	
}

