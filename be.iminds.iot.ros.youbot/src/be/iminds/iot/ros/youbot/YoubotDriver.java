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
package be.iminds.iot.ros.youbot;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.ros.api.Ros;
import be.iminds.iot.ros.util.NativeRosNode;

@Component(immediate=true,
	name="be.iminds.iot.ros.youbot.Youbot",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class YoubotDriver extends NativeRosNode {

	private Ros ros;
	
	public YoubotDriver(){
		super("youbot_driver_ros_interface","youbot_driver_ros_interface", 
				"base/joint_states:=/joint_states",
				"arm_1/joint_states:=/joint_states");
	}
	
	public void activate(Map<String, Object> properties) throws Exception {
		// for some reason youbot requires global parameters?!
		ros.setParameter("youBotHasBase", true);
		ros.setParameter("youBotHasArms", true);

		ros.setParameter("youBotBaseName", "youbot-base");
		ros.setParameter("youBotArmName1", "youbot-manipulator");
		
		super.activate(properties);
	}
	
	@Reference
	void setRos(Ros ros){
		this.ros = ros;
	}
}

