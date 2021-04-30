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
package be.iminds.iot.robot.cli;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.robot.api.omni.OmniDirectional;

@Component(service={Object.class},
	property = {"osgi.command.scope=omni", 
	"osgi.command.function=move",
	"osgi.command.function=stop"
	})
public class OmniDirectionalCLI {

	private OmniDirectional omni;
	
	public void move(float vx, float vy, float va) {
		omni.move(vx, vy, va);
	}
	
	public void stop() {
		omni.stop();
	}
	
	@Reference
	void setOmniDirectional(OmniDirectional o){
		this.omni = o;
	}
	
}
