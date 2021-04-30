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

public interface GetLinkStateRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/GetLinkStateRequest";
  static final java.lang.String _DEFINITION = "string link_name          # name of link\n                          # link names are prefixed by model name, e.g. pr2::base_link\nstring reference_frame    # reference frame of returned information, must be a valid link\n                          # if empty, use inertial (gazebo world) frame\n                          # reference_frame names are prefixed by model name, e.g. pr2::base_link\n";
  java.lang.String getLinkName();
  void setLinkName(java.lang.String value);
  java.lang.String getReferenceFrame();
  void setReferenceFrame(java.lang.String value);
}
