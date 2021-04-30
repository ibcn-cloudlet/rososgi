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

public interface ExecuteKnownTrajectoryRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/ExecuteKnownTrajectoryRequest";
  static final java.lang.String _DEFINITION = "# This service is deprecated and will go away at some point. For new development use the ExecuteTrajectory action.\n# Effective since: Indigo 0.7.4, Jade and Kinetic 0.8.3\n\n# The trajectory to execute \nRobotTrajectory trajectory\n\n# Set this to true if the service should block until the execution is complete\nbool wait_for_execution\n\n";
  moveit_msgs.RobotTrajectory getTrajectory();
  void setTrajectory(moveit_msgs.RobotTrajectory value);
  boolean getWaitForExecution();
  void setWaitForExecution(boolean value);
}
