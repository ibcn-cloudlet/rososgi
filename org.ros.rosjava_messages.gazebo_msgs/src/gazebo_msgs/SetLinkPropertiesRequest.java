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

public interface SetLinkPropertiesRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/SetLinkPropertiesRequest";
  static final java.lang.String _DEFINITION = "string link_name          # name of link\n                          # link names are prefixed by model name, e.g. pr2::base_link\ngeometry_msgs/Pose com    # center of mass location in link frame\n                          # and orientation of the moment of inertias\n                          # relative to the link frame\nbool gravity_mode         # set gravity mode on/off\nfloat64 mass              # linear mass of link\nfloat64 ixx               # moment of inertia\nfloat64 ixy               # moment of inertia\nfloat64 ixz               # moment of inertia\nfloat64 iyy               # moment of inertia\nfloat64 iyz               # moment of inertia\nfloat64 izz               # moment of inertia\n";
  java.lang.String getLinkName();
  void setLinkName(java.lang.String value);
  geometry_msgs.Pose getCom();
  void setCom(geometry_msgs.Pose value);
  boolean getGravityMode();
  void setGravityMode(boolean value);
  double getMass();
  void setMass(double value);
  double getIxx();
  void setIxx(double value);
  double getIxy();
  void setIxy(double value);
  double getIxz();
  void setIxz(double value);
  double getIyy();
  void setIyy(double value);
  double getIyz();
  void setIyz(double value);
  double getIzz();
  void setIzz(double value);
}
