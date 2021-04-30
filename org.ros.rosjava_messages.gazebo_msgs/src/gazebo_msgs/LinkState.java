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

public interface LinkState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/LinkState";
  static final java.lang.String _DEFINITION = "# @todo: FIXME: sets pose and twist of a link.  All children link poses/twists of the URDF tree are not updated accordingly, but should be.\nstring link_name            # link name, link_names are in gazebo scoped name notation, [model_name::body_name]\ngeometry_msgs/Pose pose     # desired pose in reference frame\ngeometry_msgs/Twist twist   # desired twist in reference frame\nstring reference_frame      # set pose/twist relative to the frame of this link/body\n                            # leave empty or \"world\" or \"map\" defaults to world-frame\n";
  java.lang.String getLinkName();
  void setLinkName(java.lang.String value);
  geometry_msgs.Pose getPose();
  void setPose(geometry_msgs.Pose value);
  geometry_msgs.Twist getTwist();
  void setTwist(geometry_msgs.Twist value);
  java.lang.String getReferenceFrame();
  void setReferenceFrame(java.lang.String value);
}
