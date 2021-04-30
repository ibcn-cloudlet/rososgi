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
package moveit_msgs;

public interface MoveItErrorCodes extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/MoveItErrorCodes";
  static final java.lang.String _DEFINITION = "int32 val\n\n# overall behavior\nint32 SUCCESS=1\nint32 FAILURE=99999\n\nint32 PLANNING_FAILED=-1\nint32 INVALID_MOTION_PLAN=-2\nint32 MOTION_PLAN_INVALIDATED_BY_ENVIRONMENT_CHANGE=-3\nint32 CONTROL_FAILED=-4\nint32 UNABLE_TO_AQUIRE_SENSOR_DATA=-5\nint32 TIMED_OUT=-6\nint32 PREEMPTED=-7\n\n# planning & kinematics request errors\nint32 START_STATE_IN_COLLISION=-10\nint32 START_STATE_VIOLATES_PATH_CONSTRAINTS=-11\n\nint32 GOAL_IN_COLLISION=-12\nint32 GOAL_VIOLATES_PATH_CONSTRAINTS=-13\nint32 GOAL_CONSTRAINTS_VIOLATED=-14\n\nint32 INVALID_GROUP_NAME=-15\nint32 INVALID_GOAL_CONSTRAINTS=-16\nint32 INVALID_ROBOT_STATE=-17\nint32 INVALID_LINK_NAME=-18\nint32 INVALID_OBJECT_NAME=-19\n\n# system errors\nint32 FRAME_TRANSFORM_FAILURE=-21\nint32 COLLISION_CHECKING_UNAVAILABLE=-22\nint32 ROBOT_STATE_STALE=-23\nint32 SENSOR_INFO_STALE=-24\n\n# kinematics errors\nint32 NO_IK_SOLUTION=-31\n";
  static final int SUCCESS = 1;
  static final int FAILURE = 99999;
  static final int PLANNING_FAILED = -1;
  static final int INVALID_MOTION_PLAN = -2;
  static final int MOTION_PLAN_INVALIDATED_BY_ENVIRONMENT_CHANGE = -3;
  static final int CONTROL_FAILED = -4;
  static final int UNABLE_TO_AQUIRE_SENSOR_DATA = -5;
  static final int TIMED_OUT = -6;
  static final int PREEMPTED = -7;
  static final int START_STATE_IN_COLLISION = -10;
  static final int START_STATE_VIOLATES_PATH_CONSTRAINTS = -11;
  static final int GOAL_IN_COLLISION = -12;
  static final int GOAL_VIOLATES_PATH_CONSTRAINTS = -13;
  static final int GOAL_CONSTRAINTS_VIOLATED = -14;
  static final int INVALID_GROUP_NAME = -15;
  static final int INVALID_GOAL_CONSTRAINTS = -16;
  static final int INVALID_ROBOT_STATE = -17;
  static final int INVALID_LINK_NAME = -18;
  static final int INVALID_OBJECT_NAME = -19;
  static final int FRAME_TRANSFORM_FAILURE = -21;
  static final int COLLISION_CHECKING_UNAVAILABLE = -22;
  static final int ROBOT_STATE_STALE = -23;
  static final int SENSOR_INFO_STALE = -24;
  static final int NO_IK_SOLUTION = -31;
  int getVal();
  void setVal(int value);
}
