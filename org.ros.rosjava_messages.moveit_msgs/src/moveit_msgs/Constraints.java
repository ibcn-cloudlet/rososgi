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

public interface Constraints extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/Constraints";
  static final java.lang.String _DEFINITION = "# This message contains a list of motion planning constraints.\n# All constraints must be satisfied for a goal to be considered valid\n\nstring name\n\nJointConstraint[] joint_constraints\n\nPositionConstraint[] position_constraints\n\nOrientationConstraint[] orientation_constraints\n\nVisibilityConstraint[] visibility_constraints\n";
  java.lang.String getName();
  void setName(java.lang.String value);
  java.util.List<moveit_msgs.JointConstraint> getJointConstraints();
  void setJointConstraints(java.util.List<moveit_msgs.JointConstraint> value);
  java.util.List<moveit_msgs.PositionConstraint> getPositionConstraints();
  void setPositionConstraints(java.util.List<moveit_msgs.PositionConstraint> value);
  java.util.List<moveit_msgs.OrientationConstraint> getOrientationConstraints();
  void setOrientationConstraints(java.util.List<moveit_msgs.OrientationConstraint> value);
  java.util.List<moveit_msgs.VisibilityConstraint> getVisibilityConstraints();
  void setVisibilityConstraints(java.util.List<moveit_msgs.VisibilityConstraint> value);
}
