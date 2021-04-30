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
package gazebo_msgs;

public interface ApplyJointEffortRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/ApplyJointEffortRequest";
  static final java.lang.String _DEFINITION = "# set urdf joint effort\nstring joint_name           # joint to apply wrench (linear force and torque)\nfloat64 effort              # effort to apply\ntime start_time             # optional wrench application start time (seconds)\n                            # if start_time < current time, start as soon as possible\nduration duration           # optional duration of wrench application time (seconds)\n                            # if duration < 0, apply wrench continuously without end\n                            # if duration = 0, do nothing\n                            # if duration < step size, assume step size and\n                            #               display warning in status_message\n";
  java.lang.String getJointName();
  void setJointName(java.lang.String value);
  double getEffort();
  void setEffort(double value);
  org.ros.message.Time getStartTime();
  void setStartTime(org.ros.message.Time value);
  org.ros.message.Duration getDuration();
  void setDuration(org.ros.message.Duration value);
}
