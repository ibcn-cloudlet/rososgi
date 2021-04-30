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

public interface PlanningSceneWorld extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlanningSceneWorld";
  static final java.lang.String _DEFINITION = "# collision objects\nCollisionObject[] collision_objects\n\n# The octomap that represents additional collision data\noctomap_msgs/OctomapWithPose octomap\n";
  java.util.List<moveit_msgs.CollisionObject> getCollisionObjects();
  void setCollisionObjects(java.util.List<moveit_msgs.CollisionObject> value);
  octomap_msgs.OctomapWithPose getOctomap();
  void setOctomap(octomap_msgs.OctomapWithPose value);
}
