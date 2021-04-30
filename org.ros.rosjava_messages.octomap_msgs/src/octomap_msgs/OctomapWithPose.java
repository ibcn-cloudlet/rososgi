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
package octomap_msgs;

public interface OctomapWithPose extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "octomap_msgs/OctomapWithPose";
  static final java.lang.String _DEFINITION = "# A 3D map in binary format, as Octree\nHeader header\n\n# The pose of the octree with respect to the header frame \ngeometry_msgs/Pose origin\n\n# The actual octree msg\noctomap_msgs/Octomap octomap\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  geometry_msgs.Pose getOrigin();
  void setOrigin(geometry_msgs.Pose value);
  octomap_msgs.Octomap getOctomap();
  void setOctomap(octomap_msgs.Octomap value);
}
