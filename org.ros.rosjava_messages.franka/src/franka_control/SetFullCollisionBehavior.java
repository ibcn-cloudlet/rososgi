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
package franka_control;

public interface SetFullCollisionBehavior extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "franka_control/SetFullCollisionBehavior";
  static final java.lang.String _DEFINITION = "float64[7] lower_torque_thresholds_acceleration\nfloat64[7] upper_torque_thresholds_acceleration\nfloat64[7] lower_torque_thresholds_nominal\nfloat64[7] upper_torque_thresholds_nominal\nfloat64[6] lower_force_thresholds_acceleration\nfloat64[6] upper_force_thresholds_acceleration\nfloat64[6] lower_force_thresholds_nominal\nfloat64[6] upper_force_thresholds_nominal\n---\nbool success\nstring error\n\n";
}
