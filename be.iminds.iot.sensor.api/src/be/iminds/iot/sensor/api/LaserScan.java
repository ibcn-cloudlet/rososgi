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
 * Sensor value for LaserScanner sensors.
 * 
 * @author tverbele
 *
 */
public class LaserScan extends SensorValue {

	public float minAngle;
	public float maxAngle;
	
	public float minRange;
	public float maxRange;
}
