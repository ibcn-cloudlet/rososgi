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

public interface SetModeRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/SetModeRequest";
  static final java.lang.String _DEFINITION = "# set FCU mode\n#\n# Known custom modes listed here:\n# http://wiki.ros.org/mavros/CustomModes\n\n# basic modes from MAV_MODE\nuint8 MAV_MODE_PREFLIGHT\t\t= 0\nuint8 MAV_MODE_STABILIZE_DISARMED\t= 80\nuint8 MAV_MODE_STABILIZE_ARMED\t\t= 208\nuint8 MAV_MODE_MANUAL_DISARMED\t\t= 64\nuint8 MAV_MODE_MANUAL_ARMED\t\t= 192\nuint8 MAV_MODE_GUIDED_DISARMED\t\t= 88\nuint8 MAV_MODE_GUIDED_ARMED\t\t= 216\nuint8 MAV_MODE_AUTO_DISARMED\t\t= 92\nuint8 MAV_MODE_AUTO_ARMED\t\t= 220\nuint8 MAV_MODE_TEST_DISARMED\t\t= 66\nuint8 MAV_MODE_TEST_ARMED\t\t= 194\n\nuint8 base_mode\t\t# filled by MAV_MODE enum value or 0 if custom_mode != \'\'\nstring custom_mode\t# string mode representation or integer\n";
  static final byte MAV_MODE_PREFLIGHT = 0;
  static final byte MAV_MODE_STABILIZE_DISARMED = 80;
  static final byte MAV_MODE_STABILIZE_ARMED = -48;
  static final byte MAV_MODE_MANUAL_DISARMED = 64;
  static final byte MAV_MODE_MANUAL_ARMED = -64;
  static final byte MAV_MODE_GUIDED_DISARMED = 88;
  static final byte MAV_MODE_GUIDED_ARMED = -40;
  static final byte MAV_MODE_AUTO_DISARMED = 92;
  static final byte MAV_MODE_AUTO_ARMED = -36;
  static final byte MAV_MODE_TEST_DISARMED = 66;
  static final byte MAV_MODE_TEST_ARMED = -62;
  byte getBaseMode();
  void setBaseMode(byte value);
  java.lang.String getCustomMode();
  void setCustomMode(java.lang.String value);
}
