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
package mavros_msgs;

public interface HomePosition extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/HomePosition";
  static final java.lang.String _DEFINITION = "# MAVLink message: HOME_POSITION\n# http://mavlink.org/messages/common#HOME_POSITION\n\nstd_msgs/Header header\n\nfloat64 latitude\t# WGS84\nfloat64 longitude\nfloat32 altitude\t# AMSL\n\ngeometry_msgs/Vector3 position\t# local position\ngeometry_msgs/Quaternion orientation\t# XXX: verify field name (q[4])\ngeometry_msgs/Vector3 approach\t# position of the end of approach vector\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  double getLatitude();
  void setLatitude(double value);
  double getLongitude();
  void setLongitude(double value);
  float getAltitude();
  void setAltitude(float value);
  geometry_msgs.Vector3 getPosition();
  void setPosition(geometry_msgs.Vector3 value);
  geometry_msgs.Quaternion getOrientation();
  void setOrientation(geometry_msgs.Quaternion value);
  geometry_msgs.Vector3 getApproach();
  void setApproach(geometry_msgs.Vector3 value);
}
