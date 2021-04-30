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

public interface GraspPlanningRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/GraspPlanningRequest";
  static final java.lang.String _DEFINITION = "# Requests that grasp planning be performed for the target object\n# returns a list of candidate grasps to be tested and executed\n\n# the planning group used\nstring group_name\n\n# the object to be grasped\nCollisionObject target\n\n# the names of the relevant support surfaces (e.g. tables) in the collision map\n# can be left empty if no names are available\nstring[] support_surfaces\n\n# an optional list of grasps to be evaluated by the planner\nGrasp[] candidate_grasps\n\n# an optional list of obstacles that we have semantic information about\n# and that can be moved in the course of grasping\nCollisionObject[] movable_obstacles\n\n";
  java.lang.String getGroupName();
  void setGroupName(java.lang.String value);
  moveit_msgs.CollisionObject getTarget();
  void setTarget(moveit_msgs.CollisionObject value);
  java.util.List<java.lang.String> getSupportSurfaces();
  void setSupportSurfaces(java.util.List<java.lang.String> value);
  java.util.List<moveit_msgs.Grasp> getCandidateGrasps();
  void setCandidateGrasps(java.util.List<moveit_msgs.Grasp> value);
  java.util.List<moveit_msgs.CollisionObject> getMovableObstacles();
  void setMovableObstacles(java.util.List<moveit_msgs.CollisionObject> value);
}
