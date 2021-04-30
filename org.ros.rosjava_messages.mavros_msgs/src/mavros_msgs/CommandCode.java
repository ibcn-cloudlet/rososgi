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

public interface CommandCode extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/CommandCode";
  static final java.lang.String _DEFINITION = "# Some MAV_CMD command codes.\n# Actual meaning and params you may find in MAVLink documentation\n# http://mavlink.org/messages/common#ENUM_MAV_CMD\n\n# some common MAV_CMD\nuint16 CMD_DO_SET_MODE = 176\nuint16 CMD_DO_JUMP = 177\nuint16 CMD_DO_CHANGE_SPEED = 178\nuint16 CMD_DO_SET_HOME = 179\nuint16 CMD_DO_SET_RELAY = 181\nuint16 CMD_DO_REPEAT_RELAY = 182\nuint16 CMD_DO_SET_SERVO = 183\nuint16 CMD_DO_REPEAT_SERVO = 184\nuint16 CMD_DO_CONTROL_VIDEO = 200\nuint16 CMD_DO_SET_ROI = 201\nuint16 CMD_DO_MOUNT_CONTROL = 205\nuint16 CMD_DO_SET_CAM_TRIGG_DIST = 206\nuint16 CMD_DO_FENCE_ENABLE = 207\nuint16 CMD_DO_PARACHUTE = 208\nuint16 CMD_DO_INVERTED_FLIGHT = 210\nuint16 CMD_DO_MOUNT_CONTROL_QUAT = 220\nuint16 CMD_PREFLIGHT_CALIBRATION = 241\nuint16 CMD_MISSION_START = 300\nuint16 CMD_COMPONENT_ARM_DISARM = 400\nuint16 CMD_START_RX_PAIR = 500\nuint16 CMD_REQUEST_AUTOPILOT_CAPABILITIES = 520\nuint16 CMD_DO_TRIGGER_CONTROL = 2003\n\n# Waypoint related commands\nuint16 NAV_WAYPOINT = 16\nuint16 NAV_LOITER_UNLIM = 17\nuint16 NAV_LOITER_TURNS = 18\nuint16 NAV_LOITER_TIME = 19\nuint16 NAV_RETURN_TO_LAUNCH = 20\nuint16 NAV_LAND = 21\nuint16 NAV_TAKEOFF = 22\n\n";
  static final short CMD_DO_SET_MODE = 176;
  static final short CMD_DO_JUMP = 177;
  static final short CMD_DO_CHANGE_SPEED = 178;
  static final short CMD_DO_SET_HOME = 179;
  static final short CMD_DO_SET_RELAY = 181;
  static final short CMD_DO_REPEAT_RELAY = 182;
  static final short CMD_DO_SET_SERVO = 183;
  static final short CMD_DO_REPEAT_SERVO = 184;
  static final short CMD_DO_CONTROL_VIDEO = 200;
  static final short CMD_DO_SET_ROI = 201;
  static final short CMD_DO_MOUNT_CONTROL = 205;
  static final short CMD_DO_SET_CAM_TRIGG_DIST = 206;
  static final short CMD_DO_FENCE_ENABLE = 207;
  static final short CMD_DO_PARACHUTE = 208;
  static final short CMD_DO_INVERTED_FLIGHT = 210;
  static final short CMD_DO_MOUNT_CONTROL_QUAT = 220;
  static final short CMD_PREFLIGHT_CALIBRATION = 241;
  static final short CMD_MISSION_START = 300;
  static final short CMD_COMPONENT_ARM_DISARM = 400;
  static final short CMD_START_RX_PAIR = 500;
  static final short CMD_REQUEST_AUTOPILOT_CAPABILITIES = 520;
  static final short CMD_DO_TRIGGER_CONTROL = 2003;
  static final short NAV_WAYPOINT = 16;
  static final short NAV_LOITER_UNLIM = 17;
  static final short NAV_LOITER_TURNS = 18;
  static final short NAV_LOITER_TIME = 19;
  static final short NAV_RETURN_TO_LAUNCH = 20;
  static final short NAV_LAND = 21;
  static final short NAV_TAKEOFF = 22;
}
