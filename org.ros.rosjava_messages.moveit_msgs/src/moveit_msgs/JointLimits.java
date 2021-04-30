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

public interface JointLimits extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/JointLimits";
  static final java.lang.String _DEFINITION = "# This message contains information about limits of a particular joint (or control dimension)\nstring joint_name\n\n# true if the joint has position limits\nbool has_position_limits\n\n# min and max position limits\nfloat64 min_position\nfloat64 max_position\n\n# true if joint has velocity limits\nbool has_velocity_limits\n\n# max velocity limit\nfloat64 max_velocity\n# min_velocity is assumed to be -max_velocity\n\n# true if joint has acceleration limits\nbool has_acceleration_limits\n# max acceleration limit\nfloat64 max_acceleration\n# min_acceleration is assumed to be -max_acceleration\n";
  java.lang.String getJointName();
  void setJointName(java.lang.String value);
  boolean getHasPositionLimits();
  void setHasPositionLimits(boolean value);
  double getMinPosition();
  void setMinPosition(double value);
  double getMaxPosition();
  void setMaxPosition(double value);
  boolean getHasVelocityLimits();
  void setHasVelocityLimits(boolean value);
  double getMaxVelocity();
  void setMaxVelocity(double value);
  boolean getHasAccelerationLimits();
  void setHasAccelerationLimits(boolean value);
  double getMaxAcceleration();
  void setMaxAcceleration(double value);
}
