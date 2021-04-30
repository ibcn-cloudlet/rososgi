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

public interface RobotTrajectory extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/RobotTrajectory";
  static final java.lang.String _DEFINITION = "trajectory_msgs/JointTrajectory joint_trajectory\ntrajectory_msgs/MultiDOFJointTrajectory multi_dof_joint_trajectory\n";
  trajectory_msgs.JointTrajectory getJointTrajectory();
  void setJointTrajectory(trajectory_msgs.JointTrajectory value);
  trajectory_msgs.MultiDOFJointTrajectory getMultiDofJointTrajectory();
  void setMultiDofJointTrajectory(trajectory_msgs.MultiDOFJointTrajectory value);
}
