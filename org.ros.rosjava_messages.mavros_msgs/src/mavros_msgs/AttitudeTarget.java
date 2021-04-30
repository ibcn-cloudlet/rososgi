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

public interface AttitudeTarget extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/AttitudeTarget";
  static final java.lang.String _DEFINITION = "# Message for SET_ATTITUDE_TARGET\n#\n# Some complex system requires all feautures that mavlink\n# message provide. See issue #402, #418.\n\nstd_msgs/Header header\n\nuint8 type_mask\nuint8 IGNORE_ROLL_RATE = 1\t# body_rate.x\nuint8 IGNORE_PITCH_RATE = 2\t# body_rate.y\nuint8 IGNORE_YAW_RATE = 4\t# body_rate.z\nuint8 IGNORE_THRUST = 64\nuint8 IGNORE_ATTITUDE = 128\t# orientation field\n\ngeometry_msgs/Quaternion orientation\ngeometry_msgs/Vector3 body_rate\nfloat32 thrust\n";
  static final byte IGNORE_ROLL_RATE = 1;
  static final byte IGNORE_PITCH_RATE = 2;
  static final byte IGNORE_YAW_RATE = 4;
  static final byte IGNORE_THRUST = 64;
  static final byte IGNORE_ATTITUDE = -128;
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  byte getTypeMask();
  void setTypeMask(byte value);
  geometry_msgs.Quaternion getOrientation();
  void setOrientation(geometry_msgs.Quaternion value);
  geometry_msgs.Vector3 getBodyRate();
  void setBodyRate(geometry_msgs.Vector3 value);
  float getThrust();
  void setThrust(float value);
}
