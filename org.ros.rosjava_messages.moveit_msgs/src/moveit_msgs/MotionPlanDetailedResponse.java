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

public interface MotionPlanDetailedResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/MotionPlanDetailedResponse";
  static final java.lang.String _DEFINITION = "# The representation of a solution to a planning problem, including intermediate data\n\n# The starting state considered for the robot solution path\nRobotState trajectory_start\n\n# The group used for planning (usually the same as in the request)\nstring group_name\n\n# Multiple solution paths are reported, each reflecting intermediate steps in the trajectory processing\n\n# The list of reported trajectories\nRobotTrajectory[] trajectory\n\n# Description of the reported trajectories (name of processing step)\nstring[] description\n\n# The amount of time spent computing a particular step in motion plan computation \nfloat64[] processing_time\n\n# Status at the end of this plan\nMoveItErrorCodes error_code\n";
  moveit_msgs.RobotState getTrajectoryStart();
  void setTrajectoryStart(moveit_msgs.RobotState value);
  java.lang.String getGroupName();
  void setGroupName(java.lang.String value);
  java.util.List<moveit_msgs.RobotTrajectory> getTrajectory();
  void setTrajectory(java.util.List<moveit_msgs.RobotTrajectory> value);
  java.util.List<java.lang.String> getDescription();
  void setDescription(java.util.List<java.lang.String> value);
  double[] getProcessingTime();
  void setProcessingTime(double[] value);
  moveit_msgs.MoveItErrorCodes getErrorCode();
  void setErrorCode(moveit_msgs.MoveItErrorCodes value);
}
