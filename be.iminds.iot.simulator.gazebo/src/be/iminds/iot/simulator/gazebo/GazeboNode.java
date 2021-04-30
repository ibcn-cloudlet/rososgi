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
package be.iminds.iot.simulator.gazebo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import be.iminds.iot.ros.util.NativeRosNode;

/**
 * Native ROS Gazebo node. Starts Gazebo simulator.
 * 
 * @author tverbele
 *
 */
@Component(immediate=true,
	name="be.iminds.iot.simulator.gazebo.Native",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class GazeboNode extends NativeRosNode {
	
	public GazeboNode(){
		super("gazebo_ros","gazebo");
	}
	
	protected void deactivate(){
		super.deactivate();
		
		try {
			Runtime.getRuntime().exec("killall gzclient");
			Runtime.getRuntime().exec("killall gzserver");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

