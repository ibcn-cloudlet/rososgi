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

public interface ModelState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/ModelState";
  static final java.lang.String _DEFINITION = "# Set Gazebo Model pose and twist\nstring model_name           # model to set state (pose and twist)\ngeometry_msgs/Pose pose     # desired pose in reference frame\ngeometry_msgs/Twist twist   # desired twist in reference frame\nstring reference_frame      # set pose/twist relative to the frame of this entity (Body/Model)\n                            # leave empty or \"world\" or \"map\" defaults to world-frame\n\n";
  java.lang.String getModelName();
  void setModelName(java.lang.String value);
  geometry_msgs.Pose getPose();
  void setPose(geometry_msgs.Pose value);
  geometry_msgs.Twist getTwist();
  void setTwist(geometry_msgs.Twist value);
  java.lang.String getReferenceFrame();
  void setReferenceFrame(java.lang.String value);
}
