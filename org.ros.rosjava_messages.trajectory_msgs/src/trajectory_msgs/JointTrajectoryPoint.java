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
package trajectory_msgs;

public interface JointTrajectoryPoint extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "trajectory_msgs/JointTrajectoryPoint";
  static final java.lang.String _DEFINITION = "# Each trajectory point specifies either positions[, velocities[, accelerations]]\n# or positions[, effort] for the trajectory to be executed.\n# All specified values are in the same order as the joint names in JointTrajectory.msg\n\nfloat64[] positions\nfloat64[] velocities\nfloat64[] accelerations\nfloat64[] effort\nduration time_from_start\n";
  double[] getPositions();
  void setPositions(double[] value);
  double[] getVelocities();
  void setVelocities(double[] value);
  double[] getAccelerations();
  void setAccelerations(double[] value);
  double[] getEffort();
  void setEffort(double[] value);
  org.ros.message.Duration getTimeFromStart();
  void setTimeFromStart(org.ros.message.Duration value);
}
