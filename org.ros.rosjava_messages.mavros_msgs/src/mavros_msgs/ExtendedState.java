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

public interface ExtendedState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/ExtendedState";
  static final java.lang.String _DEFINITION = "# Extended autopilot state\n#\n# http://mavlink.org/messages/common#EXTENDED_SYS_STATE\n\nuint8 VTOL_STATE_UNDEFINED = 0\nuint8 VTOL_STATE_TRANSITION_TO_FW = 1\nuint8 VTOL_STATE_TRANSITION_TO_MC = 2\nuint8 VTOL_STATE_MC = 3\nuint8 VTOL_STATE_FW = 4\n\nuint8 LANDED_STATE_UNDEFINED = 0\nuint8 LANDED_STATE_ON_GROUND = 1\nuint8 LANDED_STATE_IN_AIR = 2\n\nstd_msgs/Header header\nuint8 vtol_state\nuint8 landed_state\n";
  static final byte VTOL_STATE_UNDEFINED = 0;
  static final byte VTOL_STATE_TRANSITION_TO_FW = 1;
  static final byte VTOL_STATE_TRANSITION_TO_MC = 2;
  static final byte VTOL_STATE_MC = 3;
  static final byte VTOL_STATE_FW = 4;
  static final byte LANDED_STATE_UNDEFINED = 0;
  static final byte LANDED_STATE_ON_GROUND = 1;
  static final byte LANDED_STATE_IN_AIR = 2;
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  byte getVtolState();
  void setVtolState(byte value);
  byte getLandedState();
  void setLandedState(byte value);
}
