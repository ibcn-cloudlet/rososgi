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

public interface WorkspaceParameters extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/WorkspaceParameters";
  static final java.lang.String _DEFINITION = "# This message contains a set of parameters useful in\n# setting up the volume (a box) in which the robot is allowed to move.\n# This is useful only when planning for mobile parts of \n# the robot as well.\n\n# Define the frame of reference for the box corners\nHeader header\n\n# The minumum corner of the box, with respect to the robot starting pose\ngeometry_msgs/Vector3 min_corner\n\n# The maximum corner of the box, with respect to the robot starting pose\ngeometry_msgs/Vector3 max_corner\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  geometry_msgs.Vector3 getMinCorner();
  void setMinCorner(geometry_msgs.Vector3 value);
  geometry_msgs.Vector3 getMaxCorner();
  void setMaxCorner(geometry_msgs.Vector3 value);
}
