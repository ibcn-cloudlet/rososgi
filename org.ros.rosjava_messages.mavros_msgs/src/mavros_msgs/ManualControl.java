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

public interface ManualControl extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/ManualControl";
  static final java.lang.String _DEFINITION = "# Manual Control state\nstd_msgs/Header header\nfloat32 x\nfloat32 y\nfloat32 z\nfloat32 r\nuint16 buttons\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  float getX();
  void setX(float value);
  float getY();
  void setY(float value);
  float getZ();
  void setZ(float value);
  float getR();
  void setR(float value);
  short getButtons();
  void setButtons(short value);
}
