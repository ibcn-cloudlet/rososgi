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
package gazebo_msgs;

public interface SetJointTrajectoryRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/SetJointTrajectoryRequest";
  static final java.lang.String _DEFINITION = "string model_name\ntrajectory_msgs/JointTrajectory joint_trajectory\ngeometry_msgs/Pose model_pose\nbool set_model_pose\nbool disable_physics_updates # defaults to false\n";
  java.lang.String getModelName();
  void setModelName(java.lang.String value);
  trajectory_msgs.JointTrajectory getJointTrajectory();
  void setJointTrajectory(trajectory_msgs.JointTrajectory value);
  geometry_msgs.Pose getModelPose();
  void setModelPose(geometry_msgs.Pose value);
  boolean getSetModelPose();
  void setSetModelPose(boolean value);
  boolean getDisablePhysicsUpdates();
  void setDisablePhysicsUpdates(boolean value);
}
