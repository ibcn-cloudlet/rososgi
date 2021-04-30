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
package be.iminds.iot.ros.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import be.iminds.iot.ros.api.Ros;

public class NativeRosNode {

	protected Process process;

	protected String name;
	protected String rosPackage;
	protected String rosNode;
	protected List<String> rosParameters = new ArrayList<>();
	
	public NativeRosNode(){
	}
	
	public NativeRosNode(String pkg, String node){
		this.rosPackage = pkg;
		this.rosNode = node;
	}
	
	public NativeRosNode(String pkg, String node, String... parameters){
		this.rosPackage = pkg;
		this.rosNode = node;
		
		for(String parameter : parameters){
			if(!parameter.contains(":=")){
				System.out.println("Invalid parameter: "+parameter);
				continue;
			} 
			rosParameters.add(parameter);
		}
	}
	
	@Activate
	protected void activate(Map<String, Object> properties) throws Exception {
		// this also allows to build a ROS node driven by configuration
		for(Entry<String, Object> entry : properties.entrySet()){
			String key = entry.getKey();
			// specific ros properties
			if(key.equals("ros.package")){
				rosPackage = (String) entry.getValue();
			} else if(key.equals("ros.node")){
				rosNode = (String) entry.getValue();
			} else if(key.equals("ros.mappings")){
				String extraMappings = (String) entry.getValue();
				if(extraMappings != null){
					String[] mappings = extraMappings.split(",");
					for(String mapping : mappings){
						if(!mapping.contains(":=")){
							System.out.println("Invalid mapping: "+mapping);
							continue;
						} 
						rosParameters.add(mapping);
					}
				}	
			} else if(key.equals("name")) {
				name = entry.getValue().toString();
				rosParameters.add("name:="+name);
			} else if(!key.contains(".")){ // ignore parameters with "." , most likely OSGi service props
				rosParameters.add(key+":="+entry.getValue());
			}
		}
		
		boolean roslaunch = false;
		if(rosNode.endsWith(".launch")) {
			roslaunch = true;
		}
		
		try {
			List<String> cmd = new ArrayList<>();
			if(roslaunch) {
				cmd.add("roslaunch");
			} else {
				cmd.add("rosrun");
			}
			cmd.add(rosPackage);
			cmd.add(rosNode);
			
			// use name for setting the node name
			if(name != null) {
				cmd.add("__name:="+name);
			}
			
			// add params to command
			cmd.addAll(rosParameters);
			System.out.println(cmd);
			ProcessBuilder builder = new ProcessBuilder(cmd);
			builder.inheritIO();
			process = builder.start();
		} catch(Exception e){
			System.err.println("Error launching native ros node "+rosPackage+" "+rosNode);
			throw e;
		}
	}
	
	@Deactivate
	protected void deactivate(){
		// help ... destroy doesn't gracefully ends the child process ... might not be enough :-/
		if(process!=null){
			process.destroy();
		}
	}
	
	@Reference
	void setROSEnvironment(Ros e){
		// make sure ROS core is running before activating a native node
	}
	
}
