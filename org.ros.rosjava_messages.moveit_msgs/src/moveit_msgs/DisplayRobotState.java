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

public interface DisplayRobotState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/DisplayRobotState";
  static final java.lang.String _DEFINITION = "# The robot state to display\nRobotState state\n\n# Optionally, various links can be highlighted\nObjectColor[] highlight_links\n";
  moveit_msgs.RobotState getState();
  void setState(moveit_msgs.RobotState value);
  java.util.List<moveit_msgs.ObjectColor> getHighlightLinks();
  void setHighlightLinks(java.util.List<moveit_msgs.ObjectColor> value);
}
