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

public interface Waypoint extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/Waypoint";
  static final java.lang.String _DEFINITION = "# Waypoint.msg\n#\n# ROS representation of MAVLink MISSION_ITEM\n# See mavlink documentation\n\n\n\n# see enum MAV_FRAME\nuint8 frame\nuint8 FRAME_GLOBAL = 0\nuint8 FRAME_LOCAL_NED = 1\nuint8 FRAME_MISSION = 2\nuint8 FRAME_GLOBAL_REL_ALT = 3\nuint8 FRAME_LOCAL_ENU = 4\n\n# see enum MAV_CMD and CommandCode.msg\nuint16 command\n\nbool is_current\nbool autocontinue\n# meaning of this params described in enum MAV_CMD\nfloat32 param1\nfloat32 param2\nfloat32 param3\nfloat32 param4\nfloat64 x_lat\nfloat64 y_long\nfloat64 z_alt\n";
  static final byte FRAME_GLOBAL = 0;
  static final byte FRAME_LOCAL_NED = 1;
  static final byte FRAME_MISSION = 2;
  static final byte FRAME_GLOBAL_REL_ALT = 3;
  static final byte FRAME_LOCAL_ENU = 4;
  byte getFrame();
  void setFrame(byte value);
  short getCommand();
  void setCommand(short value);
  boolean getIsCurrent();
  void setIsCurrent(boolean value);
  boolean getAutocontinue();
  void setAutocontinue(boolean value);
  float getParam1();
  void setParam1(float value);
  float getParam2();
  void setParam2(float value);
  float getParam3();
  void setParam3(float value);
  float getParam4();
  void setParam4(float value);
  double getXLat();
  void setXLat(double value);
  double getYLong();
  void setYLong(double value);
  double getZAlt();
  void setZAlt(double value);
}
