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

public interface ContactInformation extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/ContactInformation";
  static final java.lang.String _DEFINITION = "# Standard ROS header contains information \n# about the frame in which this \n# contact is specified\nHeader header\n\n# Position of the contact point\ngeometry_msgs/Point position\n\n# Normal corresponding to the contact point\ngeometry_msgs/Vector3 normal \n\n# Depth of contact point\nfloat64 depth\n\n# Name of the first body that is in contact\n# This could be a link or a namespace that represents a body\nstring contact_body_1\nuint32 body_type_1\n\n# Name of the second body that is in contact\n# This could be a link or a namespace that represents a body\nstring contact_body_2\nuint32 body_type_2\n\nuint32 ROBOT_LINK=0\nuint32 WORLD_OBJECT=1\nuint32 ROBOT_ATTACHED=2\n";
  static final int ROBOT_LINK = 0;
  static final int WORLD_OBJECT = 1;
  static final int ROBOT_ATTACHED = 2;
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  geometry_msgs.Point getPosition();
  void setPosition(geometry_msgs.Point value);
  geometry_msgs.Vector3 getNormal();
  void setNormal(geometry_msgs.Vector3 value);
  double getDepth();
  void setDepth(double value);
  java.lang.String getContactBody1();
  void setContactBody1(java.lang.String value);
  int getBodyType1();
  void setBodyType1(int value);
  java.lang.String getContactBody2();
  void setContactBody2(java.lang.String value);
  int getBodyType2();
  void setBodyType2(int value);
}
