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

public interface MotionPlanRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/MotionPlanRequest";
  static final java.lang.String _DEFINITION = "# This service contains the definition for a request to the motion\n# planner and the output it provides\n\n# Parameters for the workspace that the planner should work inside\nWorkspaceParameters workspace_parameters\n\n# Starting state updates. If certain joints should be considered\n# at positions other than the current ones, these positions should\n# be set here\nRobotState start_state\n\n# The possible goal states for the model to plan for. Each element of\n# the array defines a goal region. The goal is achieved\n# if the constraints for a particular region are satisfied\nConstraints[] goal_constraints\n\n# No state at any point along the path in the produced motion plan will violate these constraints (this applies to all points, not just waypoints)\nConstraints path_constraints\n\n# The constraints the resulting trajectory must satisfy\nTrajectoryConstraints trajectory_constraints\n\n# The name of the motion planner to use. If no name is specified,\n# a default motion planner will be used\nstring planner_id\n\n# The name of the group of joints on which this planner is operating\nstring group_name\n\n# The number of times this plan is to be computed. Shortest solution\n# will be reported.\nint32 num_planning_attempts\n\n# The maximum amount of time the motion planner is allowed to plan for (in seconds)\nfloat64 allowed_planning_time\n\n# Scaling factors for optionally reducing the maximum joint velocities and\n# accelerations.  Allowed values are in (0,1].  The maximum joint velocity and\n# acceleration specified in the robot model are multiplied by thier respective\n# factors.  If either are outside their valid ranges (importantly, this\n# includes being set to 0.0), the factor is set to the default value of 1.0\n# internally (i.e., maximum joint velocity or maximum joint acceleration).\nfloat64 max_velocity_scaling_factor\nfloat64 max_acceleration_scaling_factor\n\n";
  moveit_msgs.WorkspaceParameters getWorkspaceParameters();
  void setWorkspaceParameters(moveit_msgs.WorkspaceParameters value);
  moveit_msgs.RobotState getStartState();
  void setStartState(moveit_msgs.RobotState value);
  java.util.List<moveit_msgs.Constraints> getGoalConstraints();
  void setGoalConstraints(java.util.List<moveit_msgs.Constraints> value);
  moveit_msgs.Constraints getPathConstraints();
  void setPathConstraints(moveit_msgs.Constraints value);
  moveit_msgs.TrajectoryConstraints getTrajectoryConstraints();
  void setTrajectoryConstraints(moveit_msgs.TrajectoryConstraints value);
  java.lang.String getPlannerId();
  void setPlannerId(java.lang.String value);
  java.lang.String getGroupName();
  void setGroupName(java.lang.String value);
  int getNumPlanningAttempts();
  void setNumPlanningAttempts(int value);
  double getAllowedPlanningTime();
  void setAllowedPlanningTime(double value);
  double getMaxVelocityScalingFactor();
  void setMaxVelocityScalingFactor(double value);
  double getMaxAccelerationScalingFactor();
  void setMaxAccelerationScalingFactor(double value);
}
