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

public interface GetStateValidity extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/GetStateValidity";
  static final java.lang.String _DEFINITION = "RobotState robot_state\nstring group_name\nConstraints constraints\n\n---\n\nbool valid\nContactInformation[] contacts\nCostSource[] cost_sources\nConstraintEvalResult[] constraint_result\n";
}
