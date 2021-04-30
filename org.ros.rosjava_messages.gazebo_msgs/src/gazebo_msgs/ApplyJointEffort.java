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

public interface ApplyJointEffort extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/ApplyJointEffort";
  static final java.lang.String _DEFINITION = "# set urdf joint effort\nstring joint_name           # joint to apply wrench (linear force and torque)\nfloat64 effort              # effort to apply\ntime start_time             # optional wrench application start time (seconds)\n                            # if start_time < current time, start as soon as possible\nduration duration           # optional duration of wrench application time (seconds)\n                            # if duration < 0, apply wrench continuously without end\n                            # if duration = 0, do nothing\n                            # if duration < step size, assume step size and\n                            #               display warning in status_message\n---\nbool success                # return true if effort application is successful\nstring status_message       # comments if available\n";
}
