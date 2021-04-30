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

public interface PlaceResult extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlaceResult";
  static final java.lang.String _DEFINITION = "# ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ======\n\n# The result of the pickup attempt\nMoveItErrorCodes error_code\n\n# The full starting state of the robot at the start of the trajectory\nRobotState trajectory_start\n\n# The trajectory that moved group produced for execution\nRobotTrajectory[] trajectory_stages\n\nstring[] trajectory_descriptions\n\n# The successful place location, if any\nPlaceLocation place_location\n\n";
  moveit_msgs.MoveItErrorCodes getErrorCode();
  void setErrorCode(moveit_msgs.MoveItErrorCodes value);
  moveit_msgs.RobotState getTrajectoryStart();
  void setTrajectoryStart(moveit_msgs.RobotState value);
  java.util.List<moveit_msgs.RobotTrajectory> getTrajectoryStages();
  void setTrajectoryStages(java.util.List<moveit_msgs.RobotTrajectory> value);
  java.util.List<java.lang.String> getTrajectoryDescriptions();
  void setTrajectoryDescriptions(java.util.List<java.lang.String> value);
  moveit_msgs.PlaceLocation getPlaceLocation();
  void setPlaceLocation(moveit_msgs.PlaceLocation value);
}
