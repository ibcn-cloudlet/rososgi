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

public interface JointConstraint extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/JointConstraint";
  static final java.lang.String _DEFINITION = "# Constrain the position of a joint to be within a certain bound\nstring joint_name\n\n# the bound to be achieved is [position - tolerance_below, position + tolerance_above]\nfloat64 position\nfloat64 tolerance_above\nfloat64 tolerance_below\n\n# A weighting factor for this constraint (denotes relative importance to other constraints. Closer to zero means less important)\nfloat64 weight";
  java.lang.String getJointName();
  void setJointName(java.lang.String value);
  double getPosition();
  void setPosition(double value);
  double getToleranceAbove();
  void setToleranceAbove(double value);
  double getToleranceBelow();
  void setToleranceBelow(double value);
  double getWeight();
  void setWeight(double value);
}
