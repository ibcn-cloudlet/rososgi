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

public interface RCIn extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/RCIn";
  static final java.lang.String _DEFINITION = "# RAW RC input state\n\nstd_msgs/Header header\nuint8 rssi\nuint16[] channels\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  byte getRssi();
  void setRssi(byte value);
  short[] getChannels();
  void setChannels(short[] value);
}
