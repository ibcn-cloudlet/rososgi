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

public interface PositionIKRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PositionIKRequest";
  static final java.lang.String _DEFINITION = "# A Position IK request message\n\n# The name of the group which will be used to compute IK\n# e.g. \"right_arm\", or \"arms\" - see IK specification for multiple-groups below\n# Information from the SRDF will be used to automatically determine which link \n# to solve IK for, unless ik_link_name is also specified\nstring group_name\n\n# A RobotState consisting of hint/seed positions for the IK computation and positions \n# for all the other joints in the robot. Additional state information provided here is \n# used to specify starting positions for other joints/links on the robot.  \n# This state MUST contain state for all joints to be used by the IK solver\n# to compute IK. The list of joints that the IK solver deals with can be \n# found using the SRDF for the corresponding group\nmoveit_msgs/RobotState robot_state\n\n# A set of constraints that the IK must obey; by default, this set of constraints is empty\nConstraints constraints\n\n# Find an IK solution that avoids collisions. By default, this is false\nbool avoid_collisions\n\n# (OPTIONAL) The name of the link for which we are computing IK\n# If not specified, the link name will be inferred from a combination \n# of the group name and the SRDF. If any values are specified for ik_link_names,\n# this value is ignored\nstring ik_link_name\n\n# The stamped pose of the link, when the IK solver computes the joint values\n# for all the joints in a group. This value is ignored if pose_stamped_vector\n# has any elements specified.\ngeometry_msgs/PoseStamped pose_stamped\n\n# Multi-group parameters\n\n# (OPTIONAL) The names of the links for which we are computing IK\n# If not specified, the link name will be inferred from a combination \n# of the group name and the SRDF\nstring[] ik_link_names\n\n# (OPTIONAL) The (stamped) poses of the links we are computing IK for (when a group has more than one end effector)\n# e.g. The \"arms\" group might consist of both the \"right_arm\" and the \"left_arm\"\n# The order of the groups referred to is the same as the order setup in the SRDF\ngeometry_msgs/PoseStamped[] pose_stamped_vector\n\n# Maximum allowed time for IK calculation\nduration timeout\n\n# Maximum number of IK attempts (if using random seeds; leave as 0 for the default value specified on the param server to be used)\nint32 attempts\n\n";
  java.lang.String getGroupName();
  void setGroupName(java.lang.String value);
  moveit_msgs.RobotState getRobotState();
  void setRobotState(moveit_msgs.RobotState value);
  moveit_msgs.Constraints getConstraints();
  void setConstraints(moveit_msgs.Constraints value);
  boolean getAvoidCollisions();
  void setAvoidCollisions(boolean value);
  java.lang.String getIkLinkName();
  void setIkLinkName(java.lang.String value);
  geometry_msgs.PoseStamped getPoseStamped();
  void setPoseStamped(geometry_msgs.PoseStamped value);
  java.util.List<java.lang.String> getIkLinkNames();
  void setIkLinkNames(java.util.List<java.lang.String> value);
  java.util.List<geometry_msgs.PoseStamped> getPoseStampedVector();
  void setPoseStampedVector(java.util.List<geometry_msgs.PoseStamped> value);
  org.ros.message.Duration getTimeout();
  void setTimeout(org.ros.message.Duration value);
  int getAttempts();
  void setAttempts(int value);
}
