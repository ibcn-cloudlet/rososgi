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
package be.iminds.iot.robot.moveit;

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

import be.iminds.iot.robot.moveit.api.MoveItArmImpl;

@Component(service = {NodeMain.class},
	name="be.iminds.iot.robot.moveit.Arm",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class MoveItRosController extends AbstractNodeMain {

	private String name;
	private String gripper_topic;
	private String joint_states_topic; 
	private String[] joints;
	private String move_group_topic; 
	private String move_group;
	private String compute_ik; 
	private String compute_fk; 
	private String ef_link;
	
	private MoveItArmImpl arm;
	
	private BundleContext context;
	
	@Activate
	void activate(BundleContext context, Map<String, Object> config){
		this.context = context;
		
		if(config.containsKey("name")) {
			name = config.get("name").toString();
		} else {
			name = "arm";
		}
		
		if(config.containsKey("gripper_topic")) {
			gripper_topic = config.get("gripper_topic").toString();
		}
		
		if(config.containsKey("joint_states_topic")) {
			joint_states_topic = config.get("joint_states_topic").toString();
		}
		
		if(config.containsKey("joints")) {
			joints = config.get("joints").toString().split(",");
		}
		
		if(config.containsKey("move_group_topic")) {
			move_group_topic = config.get("move_group_topic").toString();
		}
		
		if(config.containsKey("move_group")) {
			move_group = config.get("move_group").toString();
		}
		
		if(config.containsKey("compute_ik")) {
			compute_ik = config.get("compute_ik").toString();
		}
		
		if(config.containsKey("compute_fk")) {
			compute_fk = config.get("compute_fk").toString();
		}
		
		if(config.containsKey("ef_link")) {
			ef_link = config.get("ef_link").toString();
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

		// this brings online arm services
		arm = new MoveItArmImpl(name, context, connectedNode);
		arm.register(gripper_topic, joint_states_topic, joints, move_group_topic, move_group, compute_ik, compute_fk, ef_link);
	}
}
