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
 * A sensor that generates 2D structured data with width and height.
 * 
 * Outputs Frame sensor values.
 * 
 * @author tverbele
 *
 */
public interface Camera extends Sensor {

	int getWidth();
	
	int getHeight();
	
	String getEncoding();
	
}
