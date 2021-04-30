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

public interface GetCartesianPath extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/GetCartesianPath";
  static final java.lang.String _DEFINITION = "# Define the frame for the specified waypoints\nHeader header\n\n# The start at which to start the Cartesian path\nRobotState start_state\n\n# Mandatory name of group to compute the path for\nstring group_name\n\n# Optional name of IK link for which waypoints are specified.\n# If not specified, the tip of the group (which is assumed to be a chain)\n# is assumed to be the link\nstring link_name\n\n# A sequence of waypoints to be followed by the specified link, \n# while moving the specified group, such that the group moves only\n# in a straight line between waypoints\ngeometry_msgs/Pose[] waypoints\n\n# The maximum distance (in Cartesian space) between consecutive points\n# in the returned path. This must always be specified and > 0\nfloat64 max_step\n\n# If above 0, this value is assumed to be the maximum allowed distance \n# (L infinity) in configuration space, between consecutive points.\n# If this distance is found to be above the maximum threshold, the path \n# computation fails.\nfloat64 jump_threshold\n\n# Set to true if collisions should be avoided when possible\nbool avoid_collisions\n\n# Specify additional constraints to be met by the Cartesian path\nConstraints path_constraints\n\n---\n\n# The state at which the computed path starts\nRobotState start_state\n\n# The computed solution trajectory, for the desired group, in configuration space\nRobotTrajectory solution\n\n# If the computation was incomplete, this value indicates the fraction of the path\n# that was in fact computed (nr of waypoints traveled through)\nfloat64 fraction\n\n# The error code of the computation\nMoveItErrorCodes error_code\n";
}
