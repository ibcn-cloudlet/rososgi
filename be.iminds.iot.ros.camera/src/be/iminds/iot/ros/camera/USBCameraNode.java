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
package be.iminds.iot.ros.camera;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import be.iminds.iot.ros.util.NativeRosNode;

/**
 * Native ROS USBCamera node. Starts publishing to a image_raw topic that can be 
 * exposed to OSGi via CameraSubscriber
 * 
 * @author tverbele
 *
 */
@Component(immediate=true,
		name="be.iminds.iot.ros.camera.USBCamera",
		configurationPolicy=ConfigurationPolicy.REQUIRE)
public class USBCameraNode extends NativeRosNode {
	
	public USBCameraNode(){
		super("usb_cam","usb_cam_node");
	}
	
}

