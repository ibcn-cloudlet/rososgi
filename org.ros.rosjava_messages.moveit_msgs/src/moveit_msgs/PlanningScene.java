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

public interface PlanningScene extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlanningScene";
  static final java.lang.String _DEFINITION = "# name of planning scene\nstring name\n\n# full robot state\nRobotState robot_state\n\n# The name of the robot model this scene is for\nstring robot_model_name\n\n#additional frames for duplicating tf (with respect to the planning frame)\ngeometry_msgs/TransformStamped[] fixed_frame_transforms\n\n#full allowed collision matrix\nAllowedCollisionMatrix allowed_collision_matrix\n\n# all link paddings\nLinkPadding[] link_padding\n\n# all link scales\nLinkScale[] link_scale\n\n# Attached objects, collision objects, even the octomap or collision map can have \n# colors associated to them. This array specifies them.\nObjectColor[] object_colors\n\n# the collision map\nPlanningSceneWorld world\n\n# Flag indicating whether this scene is to be interpreted as a diff with respect to some other scene\nbool is_diff\n";
  java.lang.String getName();
  void setName(java.lang.String value);
  moveit_msgs.RobotState getRobotState();
  void setRobotState(moveit_msgs.RobotState value);
  java.lang.String getRobotModelName();
  void setRobotModelName(java.lang.String value);
  java.util.List<geometry_msgs.TransformStamped> getFixedFrameTransforms();
  void setFixedFrameTransforms(java.util.List<geometry_msgs.TransformStamped> value);
  moveit_msgs.AllowedCollisionMatrix getAllowedCollisionMatrix();
  void setAllowedCollisionMatrix(moveit_msgs.AllowedCollisionMatrix value);
  java.util.List<moveit_msgs.LinkPadding> getLinkPadding();
  void setLinkPadding(java.util.List<moveit_msgs.LinkPadding> value);
  java.util.List<moveit_msgs.LinkScale> getLinkScale();
  void setLinkScale(java.util.List<moveit_msgs.LinkScale> value);
  java.util.List<moveit_msgs.ObjectColor> getObjectColors();
  void setObjectColors(java.util.List<moveit_msgs.ObjectColor> value);
  moveit_msgs.PlanningSceneWorld getWorld();
  void setWorld(moveit_msgs.PlanningSceneWorld value);
  boolean getIsDiff();
  void setIsDiff(boolean value);
}
