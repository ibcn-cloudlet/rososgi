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
 * Sensor that scans ranges in 1 dimension.
 * 
 * @author tverbele
 *
 */
public interface LaserScanner extends Sensor {

	float getMinAngle();
	
	float getMaxAngle();
	
	float getMinRange();
	
	float getMaxRange();
	
}
