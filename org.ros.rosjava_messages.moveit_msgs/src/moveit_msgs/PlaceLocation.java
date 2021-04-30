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

public interface PlaceLocation extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlaceLocation";
  static final java.lang.String _DEFINITION = "# A name for this grasp\nstring id\n\n# The internal posture of the hand for the grasp\n# positions and efforts are used\ntrajectory_msgs/JointTrajectory post_place_posture\n\n# The position of the end-effector for the grasp relative to a reference frame \n# (that is always specified elsewhere, not in this message)\ngeometry_msgs/PoseStamped place_pose\n\n# The approach motion\nGripperTranslation pre_place_approach\n\n# The retreat motion\nGripperTranslation post_place_retreat\n\n# an optional list of obstacles that we have semantic information about\n# and that can be touched/pushed/moved in the course of grasping\nstring[] allowed_touch_objects\n";
  java.lang.String getId();
  void setId(java.lang.String value);
  trajectory_msgs.JointTrajectory getPostPlacePosture();
  void setPostPlacePosture(trajectory_msgs.JointTrajectory value);
  geometry_msgs.PoseStamped getPlacePose();
  void setPlacePose(geometry_msgs.PoseStamped value);
  moveit_msgs.GripperTranslation getPrePlaceApproach();
  void setPrePlaceApproach(moveit_msgs.GripperTranslation value);
  moveit_msgs.GripperTranslation getPostPlaceRetreat();
  void setPostPlaceRetreat(moveit_msgs.GripperTranslation value);
  java.util.List<java.lang.String> getAllowedTouchObjects();
  void setAllowedTouchObjects(java.util.List<java.lang.String> value);
}
