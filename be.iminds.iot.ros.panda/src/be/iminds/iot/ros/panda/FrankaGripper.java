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
package be.iminds.iot.ros.panda;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import be.iminds.iot.ros.util.NativeRosNode;

@Component(immediate=true,
	configurationPid="be.iminds.iot.ros.panda.Panda",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class FrankaGripper extends NativeRosNode {

	public FrankaGripper(){
		super("franka_gripper",
			  "franka_gripper.launch");
	}
}

