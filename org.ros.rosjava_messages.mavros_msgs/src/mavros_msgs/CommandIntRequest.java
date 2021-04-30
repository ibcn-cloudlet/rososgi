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

public interface CommandIntRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/CommandIntRequest";
  static final java.lang.String _DEFINITION = "# Generic COMMAND_INT\n\nbool broadcast # send this command in broadcast mode\n\nuint8 frame\nuint16 command\nuint8 current\nuint8 autocontinue\nfloat32 param1\nfloat32 param2\nfloat32 param3\nfloat32 param4\nint32 x\t# latitude in deg * 1E7 or local x * 1E4 m\nint32 y\t# longitude in deg * 1E7 or local y * 1E4 m\nfloat32 z\t# altitude\n";
  boolean getBroadcast();
  void setBroadcast(boolean value);
  byte getFrame();
  void setFrame(byte value);
  short getCommand();
  void setCommand(short value);
  byte getCurrent();
  void setCurrent(byte value);
  byte getAutocontinue();
  void setAutocontinue(byte value);
  float getParam1();
  void setParam1(float value);
  float getParam2();
  void setParam2(float value);
  float getParam3();
  void setParam3(float value);
  float getParam4();
  void setParam4(float value);
  int getX();
  void setX(int value);
  int getY();
  void setY(int value);
  float getZ();
  void setZ(float value);
}
