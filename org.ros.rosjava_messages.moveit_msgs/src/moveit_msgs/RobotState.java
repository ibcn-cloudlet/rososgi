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
package moveit_msgs;

public interface RobotState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/RobotState";
  static final java.lang.String _DEFINITION = "# This message contains information about the robot state, i.e. the positions of its joints and links\nsensor_msgs/JointState joint_state\n\n# Joints that may have multiple DOF are specified here\nsensor_msgs/MultiDOFJointState multi_dof_joint_state\n\n# Attached collision objects (attached to some link on the robot)\nAttachedCollisionObject[] attached_collision_objects\n\n# Flag indicating whether this scene is to be interpreted as a diff with respect to some other scene\n# This is mostly important for handling the attached bodies (whether or not to clear the attached bodies\n# of a moveit::core::RobotState before updating it with this message)\nbool is_diff\n";
  sensor_msgs.JointState getJointState();
  void setJointState(sensor_msgs.JointState value);
  sensor_msgs.MultiDOFJointState getMultiDofJointState();
  void setMultiDofJointState(sensor_msgs.MultiDOFJointState value);
  java.util.List<moveit_msgs.AttachedCollisionObject> getAttachedCollisionObjects();
  void setAttachedCollisionObjects(java.util.List<moveit_msgs.AttachedCollisionObject> value);
  boolean getIsDiff();
  void setIsDiff(boolean value);
}
