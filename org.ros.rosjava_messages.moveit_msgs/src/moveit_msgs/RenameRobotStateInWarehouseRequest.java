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

public interface RenameRobotStateInWarehouseRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/RenameRobotStateInWarehouseRequest";
  static final java.lang.String _DEFINITION = "string old_name\nstring new_name\nstring robot\n";
  java.lang.String getOldName();
  void setOldName(java.lang.String value);
  java.lang.String getNewName();
  void setNewName(java.lang.String value);
  java.lang.String getRobot();
  void setRobot(java.lang.String value);
}
