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
package be.iminds.iot.sensor.api;

/**
 * A sensor that generates point clouds, for example certain RADAR / Depth cameras with on-board processing.
 * 
 * @author tverbele
 *
 */
public interface Scanner3D extends Sensor {
	
	String[] getFields();
	
}
