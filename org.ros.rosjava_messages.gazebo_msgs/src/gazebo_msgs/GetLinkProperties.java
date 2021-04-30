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

public interface GetLinkProperties extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/GetLinkProperties";
  static final java.lang.String _DEFINITION = "string link_name          # name of link\n                          # link names are prefixed by model name, e.g. pr2::base_link\n---\ngeometry_msgs/Pose com    # center of mass location in link frame\n                          # and orientation of the moment of inertias\n                          # relative to the link frame\nbool gravity_mode         # set gravity mode on/off\nfloat64 mass              # linear mass of link\nfloat64 ixx               # moment of inertia\nfloat64 ixy               # moment of inertia\nfloat64 ixz               # moment of inertia\nfloat64 iyy               # moment of inertia\nfloat64 iyz               # moment of inertia\nfloat64 izz               # moment of inertia\nbool success              # return true if get info is successful\nstring status_message     # comments if available\n";
}
