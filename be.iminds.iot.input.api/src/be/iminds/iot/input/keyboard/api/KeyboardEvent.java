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
package be.iminds.iot.input.keyboard.api;

public class KeyboardEvent {

	
	public enum Type {
		PRESSED,
		RELEASED
	}
	
	public final Type type;
	public final String key;
	
	public KeyboardEvent(Type type, String key){
		this.type = type;
		this.key = key;
	}
	
	@Override
	public String toString(){
		return key+" "+type;
	}
}
