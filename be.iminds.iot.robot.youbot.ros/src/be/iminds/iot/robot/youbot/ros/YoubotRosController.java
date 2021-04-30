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
package be.iminds.iot.robot.youbot.ros;

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
	name="be.iminds.iot.robot.youbot.ros.Youbot",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class YoubotRosController extends AbstractNodeMain {

	private String name;
	private ArmImpl arm;
	private BaseImpl base;
	
	private BundleContext context;
	
	@Activate
	void activate(BundleContext context, Map<String, Object> config){
		this.context = context;
		
		name = config.get("name").toString();
		if(name == null){
			name = "Youbot";
		}
	}
	
	@Deactivate
	void deactivate(){
		// TODO on the real robot we get a deactivate when initializing configuration?!
		//System.out.println("Deactivate Youbot ROS Controller?!");
		try {
			base.stop();
			arm.reset();
		} catch(Exception e){}
		
		arm.unregister();
		base.unregister();
	}
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("youbot/controller");
	}
	
	@Override
	public void onStart(ConnectedNode connectedNode){
		connectedNode.getTopicMessageFactory();

		// this brings online arm and base services
		arm = new ArmImpl(name, context, connectedNode);
		arm.register();
		
		base = new BaseImpl(name, context, connectedNode);
		base.register();
	}
}
