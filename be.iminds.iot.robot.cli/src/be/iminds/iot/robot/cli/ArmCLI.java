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

import be.iminds.iot.robot.api.arm.Arm;

@Component(service={Object.class},
	property = {"osgi.command.scope=arm", 
	"osgi.command.function=state",
	"osgi.command.function=open",
	"osgi.command.function=close",
	"osgi.command.function=position",
	"osgi.command.function=velocity",
	"osgi.command.function=torque",
	"osgi.command.function=move",
	"osgi.command.function=pose",
	"osgi.command.function=halt",
	"osgi.command.function=stop",
	"osgi.command.function=recover",
	"osgi.command.function=speed",
	"osgi.command.function=guide",
	"osgi.command.function=grasped"})
public class ArmCLI {

	private Arm arm;
	
	public void state(){
		arm.getState().forEach(s -> System.out.println(s.joint+" "+s.position+" "+s.velocity+" "+s.torque));
	}

	public void position(float... positions){
		arm.setPositions(positions);
	}
	
	public void position(int joint, float val){
		arm.setPosition(joint, val).then(p -> {System.out.println("DONE"); return null;}, p->p.getFailure().printStackTrace());
	}
	
	public void velocity(int joint, float val){
		arm.setVelocity(joint, val);
	}
	
	public void velocity(float... velocities) {
		arm.setVelocities(velocities);
	}
	
	public void torque(int joint, float val){
		arm.setTorque(joint, val);
	}
	
	public void torque(float... torques) {
		arm.setTorques(torques);
	}
	
	public void open(float opening){
		arm.openGripper(opening);
	}
	
	public void open(){
		arm.openGripper();
	}
	
	public void close(){
		arm.closeGripper();
	}
	
	public void pose() {
		System.out.println(arm.getPose());
	}
	
	public void pose(float x, float y, float z){
		arm.moveTo(x, y, z).then(p -> {System.out.println("DONE");return null;}, p->{p.getFailure().printStackTrace();});
		
	}
	
	public void pose(float x, float y, float z, float ox, float oy, float oz, float ow){
		arm.moveTo(x, y, z, ox, oy, oz, ow).then(p -> {System.out.println("DONE");return null;}, p->{p.getFailure().printStackTrace();});
	}
	
	public void move(float vx, float vy, float vz) {
		arm.move(vx, vy, vz).then(p -> {System.out.println("DONE");return null;}, p->{p.getFailure().printStackTrace();});
	}
	
	public void move(float vx, float vy, float vz, float ox, float oy, float oz) {
		arm.move(vx, vy, vz, ox, oy, oz).then(p -> {System.out.println("DONE");return null;}, p->{p.getFailure().printStackTrace();});
	}
	
	public void stop(){
		arm.stop();
	}
	
	public void halt(){
		arm.stop();
	}
	
	public void speed() {
		System.out.println(arm.getSpeed());
	}
	
	public void speed(float s) {
		arm.setSpeed(s);
	}
	
	public void recover(){
		arm.recover();
	}
	
	public void guide(){
		arm.guide();
	}
	
	public boolean grasped() {
		return arm.isGrasped();
	}
	
	@Reference
	void setArm(Arm arm){
		this.arm = arm;
	}
	
}
