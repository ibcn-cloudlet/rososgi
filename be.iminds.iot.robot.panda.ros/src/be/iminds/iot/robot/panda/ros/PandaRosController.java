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
package be.iminds.iot.robot.panda.ros;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.NodeMain;

@Component(service = {NodeMain.class},
	name="be.iminds.iot.robot.panda.ros.Panda",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class PandaRosController extends AbstractNodeMain {

	private String name;
	
	private PandaArmImpl arm;
	
	private BundleContext context;
	
	@Activate
	void activate(BundleContext context, Map<String, Object> config){
		this.context = context;
		
		if(config.containsKey("name")) {
			name = config.get("name").toString();
		} else {
			name = "panda";
		}
	}
	
	@Deactivate
	void deactivate(){
		try {
			arm.reset();
		} catch(Exception e){}
		
		arm.unregister();
	}
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of(name.toLowerCase()+"/controller");
	}
	
	@Override
	public void onStart(ConnectedNode connectedNode){
		connectedNode.getTopicMessageFactory();
		arm = new PandaArmImpl(name, context, connectedNode);
		arm.register();
	}
}
