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
package franka_msgs;

public interface Errors extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "franka_msgs/Errors";
  static final java.lang.String _DEFINITION = "bool joint_position_limits_violation\nbool cartesian_position_limits_violation\nbool self_collision_avoidance_violation\nbool joint_velocity_violation\nbool cartesian_velocity_violation\nbool force_control_safety_violation\nbool joint_reflex\nbool cartesian_reflex\nbool max_goal_pose_deviation_violation\nbool max_path_pose_deviation_violation\nbool cartesian_velocity_profile_safety_violation\nbool joint_position_motion_generator_start_pose_invalid\nbool joint_motion_generator_position_limits_violation\nbool joint_motion_generator_velocity_limits_violation\nbool joint_motion_generator_velocity_discontinuity\nbool joint_motion_generator_acceleration_discontinuity\nbool cartesian_position_motion_generator_start_pose_invalid\nbool cartesian_motion_generator_elbow_limit_violation\nbool cartesian_motion_generator_velocity_limits_violation\nbool cartesian_motion_generator_velocity_discontinuity\nbool cartesian_motion_generator_acceleration_discontinuity\nbool cartesian_motion_generator_elbow_sign_inconsistent\nbool cartesian_motion_generator_start_elbow_invalid\nbool cartesian_motion_generator_joint_position_limits_violation\nbool cartesian_motion_generator_joint_velocity_limits_violation\nbool cartesian_motion_generator_joint_velocity_discontinuity\nbool cartesian_motion_generator_joint_acceleration_discontinuity\nbool cartesian_position_motion_generator_invalid_frame\nbool force_controller_desired_force_tolerance_violation\nbool controller_torque_discontinuity\nbool start_elbow_sign_inconsistent\nbool communication_constraints_violation\nbool power_limit_violation\n";
  boolean getJointPositionLimitsViolation();
  void setJointPositionLimitsViolation(boolean value);
  boolean getCartesianPositionLimitsViolation();
  void setCartesianPositionLimitsViolation(boolean value);
  boolean getSelfCollisionAvoidanceViolation();
  void setSelfCollisionAvoidanceViolation(boolean value);
  boolean getJointVelocityViolation();
  void setJointVelocityViolation(boolean value);
  boolean getCartesianVelocityViolation();
  void setCartesianVelocityViolation(boolean value);
  boolean getForceControlSafetyViolation();
  void setForceControlSafetyViolation(boolean value);
  boolean getJointReflex();
  void setJointReflex(boolean value);
  boolean getCartesianReflex();
  void setCartesianReflex(boolean value);
  boolean getMaxGoalPoseDeviationViolation();
  void setMaxGoalPoseDeviationViolation(boolean value);
  boolean getMaxPathPoseDeviationViolation();
  void setMaxPathPoseDeviationViolation(boolean value);
  boolean getCartesianVelocityProfileSafetyViolation();
  void setCartesianVelocityProfileSafetyViolation(boolean value);
  boolean getJointPositionMotionGeneratorStartPoseInvalid();
  void setJointPositionMotionGeneratorStartPoseInvalid(boolean value);
  boolean getJointMotionGeneratorPositionLimitsViolation();
  void setJointMotionGeneratorPositionLimitsViolation(boolean value);
  boolean getJointMotionGeneratorVelocityLimitsViolation();
  void setJointMotionGeneratorVelocityLimitsViolation(boolean value);
  boolean getJointMotionGeneratorVelocityDiscontinuity();
  void setJointMotionGeneratorVelocityDiscontinuity(boolean value);
  boolean getJointMotionGeneratorAccelerationDiscontinuity();
  void setJointMotionGeneratorAccelerationDiscontinuity(boolean value);
  boolean getCartesianPositionMotionGeneratorStartPoseInvalid();
  void setCartesianPositionMotionGeneratorStartPoseInvalid(boolean value);
  boolean getCartesianMotionGeneratorElbowLimitViolation();
  void setCartesianMotionGeneratorElbowLimitViolation(boolean value);
  boolean getCartesianMotionGeneratorVelocityLimitsViolation();
  void setCartesianMotionGeneratorVelocityLimitsViolation(boolean value);
  boolean getCartesianMotionGeneratorVelocityDiscontinuity();
  void setCartesianMotionGeneratorVelocityDiscontinuity(boolean value);
  boolean getCartesianMotionGeneratorAccelerationDiscontinuity();
  void setCartesianMotionGeneratorAccelerationDiscontinuity(boolean value);
  boolean getCartesianMotionGeneratorElbowSignInconsistent();
  void setCartesianMotionGeneratorElbowSignInconsistent(boolean value);
  boolean getCartesianMotionGeneratorStartElbowInvalid();
  void setCartesianMotionGeneratorStartElbowInvalid(boolean value);
  boolean getCartesianMotionGeneratorJointPositionLimitsViolation();
  void setCartesianMotionGeneratorJointPositionLimitsViolation(boolean value);
  boolean getCartesianMotionGeneratorJointVelocityLimitsViolation();
  void setCartesianMotionGeneratorJointVelocityLimitsViolation(boolean value);
  boolean getCartesianMotionGeneratorJointVelocityDiscontinuity();
  void setCartesianMotionGeneratorJointVelocityDiscontinuity(boolean value);
  boolean getCartesianMotionGeneratorJointAccelerationDiscontinuity();
  void setCartesianMotionGeneratorJointAccelerationDiscontinuity(boolean value);
  boolean getCartesianPositionMotionGeneratorInvalidFrame();
  void setCartesianPositionMotionGeneratorInvalidFrame(boolean value);
  boolean getForceControllerDesiredForceToleranceViolation();
  void setForceControllerDesiredForceToleranceViolation(boolean value);
  boolean getControllerTorqueDiscontinuity();
  void setControllerTorqueDiscontinuity(boolean value);
  boolean getStartElbowSignInconsistent();
  void setStartElbowSignInconsistent(boolean value);
  boolean getCommunicationConstraintsViolation();
  void setCommunicationConstraintsViolation(boolean value);
  boolean getPowerLimitViolation();
  void setPowerLimitViolation(boolean value);
}
