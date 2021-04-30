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

public interface PositionTarget extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/PositionTarget";
  static final java.lang.String _DEFINITION = "# Message for SET_POSITION_TARGET_LOCAL_NED\n#\n# Some complex system requires all feautures that mavlink\n# message provide. See issue #402.\n\nstd_msgs/Header header\n\nuint8 coordinate_frame\nuint8 FRAME_LOCAL_NED = 1\nuint8 FRAME_LOCAL_OFFSET_NED = 7\nuint8 FRAME_BODY_NED = 8\nuint8 FRAME_BODY_OFFSET_NED = 9\n\nuint16 type_mask\nuint16 IGNORE_PX = 1\t# Position ignore flags\nuint16 IGNORE_PY = 2\nuint16 IGNORE_PZ = 4\nuint16 IGNORE_VX = 8\t# Velocity vector ignore flags\nuint16 IGNORE_VY = 16\nuint16 IGNORE_VZ = 32\nuint16 IGNORE_AFX = 64\t# Acceleration/Force vector ignore flags\nuint16 IGNORE_AFY = 128\nuint16 IGNORE_AFZ = 256\nuint16 FORCE = 512\t# Force in af vector flag\nuint16 IGNORE_YAW = 1024\nuint16 IGNORE_YAW_RATE = 2048\n\ngeometry_msgs/Point position\ngeometry_msgs/Vector3 velocity\ngeometry_msgs/Vector3 acceleration_or_force\nfloat32 yaw\nfloat32 yaw_rate\n";
  static final byte FRAME_LOCAL_NED = 1;
  static final byte FRAME_LOCAL_OFFSET_NED = 7;
  static final byte FRAME_BODY_NED = 8;
  static final byte FRAME_BODY_OFFSET_NED = 9;
  static final short IGNORE_PX = 1;
  static final short IGNORE_PY = 2;
  static final short IGNORE_PZ = 4;
  static final short IGNORE_VX = 8;
  static final short IGNORE_VY = 16;
  static final short IGNORE_VZ = 32;
  static final short IGNORE_AFX = 64;
  static final short IGNORE_AFY = 128;
  static final short IGNORE_AFZ = 256;
  static final short FORCE = 512;
  static final short IGNORE_YAW = 1024;
  static final short IGNORE_YAW_RATE = 2048;
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  byte getCoordinateFrame();
  void setCoordinateFrame(byte value);
  short getTypeMask();
  void setTypeMask(short value);
  geometry_msgs.Point getPosition();
  void setPosition(geometry_msgs.Point value);
  geometry_msgs.Vector3 getVelocity();
  void setVelocity(geometry_msgs.Vector3 value);
  geometry_msgs.Vector3 getAccelerationOrForce();
  void setAccelerationOrForce(geometry_msgs.Vector3 value);
  float getYaw();
  void setYaw(float value);
  float getYawRate();
  void setYawRate(float value);
}
