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
package controller_manager_msgs;

public interface ControllerStatistics extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "controller_manager_msgs/ControllerStatistics";
  static final java.lang.String _DEFINITION = "# This message contains the state of one realtime controller\n# that was spawned in the controller manager\n\n# the name of the controller\nstring name\n\n# the type of the controller\nstring type\n\n# the time at which these controller statistics were measured\ntime timestamp\n\n# bool that indicates if the controller is currently\n# in a running or a stopped state\nbool running\n\n# the maximum time the update loop of the controller ever needed to complete\nduration max_time\n\n# the average time the update loop of the controller needs to complete.\n# the average is computed in a sliding time window.\nduration mean_time\n\n# the variance on the time the update loop of the controller needs to complete.\n# the variance applies to a sliding time window.\nduration variance_time\n\n# the number of times this controller broke the realtime loop\nint32 num_control_loop_overruns\n\n# the timestamp of the last time this controller broke the realtime loop\ntime time_last_control_loop_overrun";
  java.lang.String getName();
  void setName(java.lang.String value);
  java.lang.String getType();
  void setType(java.lang.String value);
  org.ros.message.Time getTimestamp();
  void setTimestamp(org.ros.message.Time value);
  boolean getRunning();
  void setRunning(boolean value);
  org.ros.message.Duration getMaxTime();
  void setMaxTime(org.ros.message.Duration value);
  org.ros.message.Duration getMeanTime();
  void setMeanTime(org.ros.message.Duration value);
  org.ros.message.Duration getVarianceTime();
  void setVarianceTime(org.ros.message.Duration value);
  int getNumControlLoopOverruns();
  void setNumControlLoopOverruns(int value);
  org.ros.message.Time getTimeLastControlLoopOverrun();
  void setTimeLastControlLoopOverrun(org.ros.message.Time value);
}
