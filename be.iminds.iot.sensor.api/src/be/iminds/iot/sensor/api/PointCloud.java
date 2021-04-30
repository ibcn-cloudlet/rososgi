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
 * Sensor value for 3D scanner typed sensors.
 * 
 * @author tverbele
 *
 */
public class PointCloud extends SensorValue {

	// number of points
	public int size;
	
	// number of fields per point + name for each point
	public String[] fields;
	
}
