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
package be.iminds.iot.ros.erlerover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * Start APM rover process
 * 
 * TODO seems not to work ... for now launch it ourselves outside of OSGi?!
 * TODO take a look how this (w/c)ould work on the real rover
 * 
 * @author tverbele
 *
 */
@Component(immediate = true)
public class APMrover {

	private Process apmProcess;

	private String path = "/home/erle/ardupilot/APMrover2";

	@Activate
	void activate(final BundleContext context) {
		Thread t = new Thread(()->{
			try {
				ProcessBuilder builder = new ProcessBuilder("../Tools/autotest/sim_vehicle.sh", "-j", "4", "-f", "Gazebo","-v","APMrover2");
				builder.directory(new File(path));
				System.out.println("Starting APMrover process");
				apmProcess = builder.start();
	
				PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(apmProcess.getOutputStream())));
				BufferedReader reader = new BufferedReader(new InputStreamReader(apmProcess.getInputStream()));
				
				boolean done = false;
				while(!done){
					String line = reader.readLine();
					if(line.startsWith("Connect")){
						done = true;
					}
				}
				// TODO: this appears not to work from sub-process in Java?!
				writer.println("param load "+path+"/../Tools/Frame_params/3DR_Rover.param");
				writer.println("param set SYSID_MYGCS 1");
				
				context.registerService(new String[]{APMService.class.getName()}, new APMService(){}, new Hashtable<>());
				
				while(true){
					System.out.println("HERE?! >> "+reader.readLine());
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		});
		t.start();
		context.registerService(new String[]{APMService.class.getName()}, new APMService(){}, new Hashtable<>());

	}

	@Deactivate
	void deactivate() {
		if(apmProcess != null){
			apmProcess.destroy();
		}
	}

}
