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
package be.iminds.iot.robot.api.omni;

import java.util.Collection;

import org.osgi.util.promise.Promise;

import be.iminds.iot.robot.api.JointValue;
import be.iminds.iot.robot.api.Robot;

/**
 * API for controlling an omnidirectional robot
 * 
 * @author tverbele
 *
 */
public interface OmniDirectional extends Robot<OmniDirectional> {

	Promise<OmniDirectional> setVelocities(Collection<JointValue> velocities);
	
	Promise<OmniDirectional> move(float vx, float vy, float va);
	
}
