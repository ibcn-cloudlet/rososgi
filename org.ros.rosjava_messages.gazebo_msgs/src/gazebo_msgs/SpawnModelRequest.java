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

public interface SpawnModelRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/SpawnModelRequest";
  static final java.lang.String _DEFINITION = "string model_name                 # name of the model to be spawn\nstring model_xml                  # this should be an urdf or gazebo xml\nstring robot_namespace            # spawn robot and all ROS interfaces under this namespace\ngeometry_msgs/Pose initial_pose   # only applied to canonical body\nstring reference_frame            # initial_pose is defined relative to the frame of this model/body\n                                  # if left empty or \"world\", then gazebo world frame is used\n                                  # if non-existent model/body is specified, an error is returned\n                                  #   and the model is not spawned\n";
  java.lang.String getModelName();
  void setModelName(java.lang.String value);
  java.lang.String getModelXml();
  void setModelXml(java.lang.String value);
  java.lang.String getRobotNamespace();
  void setRobotNamespace(java.lang.String value);
  geometry_msgs.Pose getInitialPose();
  void setInitialPose(geometry_msgs.Pose value);
  java.lang.String getReferenceFrame();
  void setReferenceFrame(java.lang.String value);
}
