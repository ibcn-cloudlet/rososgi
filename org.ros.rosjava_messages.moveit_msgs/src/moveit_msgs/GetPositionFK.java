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

public interface GetPositionFK extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/GetPositionFK";
  static final java.lang.String _DEFINITION = "# A service definition for a standard forward kinematics service\n# The frame_id in the header message is the frame in which \n# the forward kinematics poses will be returned\nHeader header\n\n# A vector of link name for which forward kinematics must be computed\nstring[] fk_link_names\n\n# A robot state consisting of joint names and joint positions to be used for forward kinematics\nRobotState robot_state\n---\n# The resultant vector of PoseStamped messages that contains the (stamped) poses of the requested links\ngeometry_msgs/PoseStamped[] pose_stamped\n\n# The list of link names corresponding to the poses\nstring[] fk_link_names\n\nMoveItErrorCodes error_code\n";
}
