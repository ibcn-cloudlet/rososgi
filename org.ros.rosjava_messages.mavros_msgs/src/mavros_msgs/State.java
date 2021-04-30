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

public interface State extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/State";
  static final java.lang.String _DEFINITION = "# Current autopilot state\n#\n# Known modes listed here:\n# http://wiki.ros.org/mavros/CustomModes\n\nstd_msgs/Header header\nbool connected\nbool armed\nbool guided\nstring mode\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  boolean getConnected();
  void setConnected(boolean value);
  boolean getArmed();
  void setArmed(boolean value);
  boolean getGuided();
  void setGuided(boolean value);
  java.lang.String getMode();
  void setMode(java.lang.String value);
}
