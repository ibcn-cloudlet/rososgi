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

public interface OrientedBoundingBox extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/OrientedBoundingBox";
  static final java.lang.String _DEFINITION = "# the pose of the box\ngeometry_msgs/Pose pose\n\n# the extents of the box, assuming the center is at the origin\ngeometry_msgs/Point32 extents\n";
  geometry_msgs.Pose getPose();
  void setPose(geometry_msgs.Pose value);
  geometry_msgs.Point32 getExtents();
  void setExtents(geometry_msgs.Point32 value);
}
