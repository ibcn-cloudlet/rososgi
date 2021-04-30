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

public interface ControllersStatistics extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "controller_manager_msgs/ControllersStatistics";
  static final java.lang.String _DEFINITION = "std_msgs/Header header\ncontroller_manager_msgs/ControllerStatistics[] controller\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  java.util.List<controller_manager_msgs.ControllerStatistics> getController();
  void setController(java.util.List<controller_manager_msgs.ControllerStatistics> value);
}
