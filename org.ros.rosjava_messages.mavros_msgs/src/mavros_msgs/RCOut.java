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

public interface RCOut extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/RCOut";
  static final java.lang.String _DEFINITION = "# RAW Servo out state\n\nstd_msgs/Header header\nuint16[] channels\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  short[] getChannels();
  void setChannels(short[] value);
}
