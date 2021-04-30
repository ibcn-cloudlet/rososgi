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

public interface GetConstraintAwarePositionIK extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/GetConstraintAwarePositionIK";
  static final java.lang.String _DEFINITION = "# A service call to carry out an inverse kinematics computation\n# The inverse kinematics request\nPositionIKRequest ik_request\n\n# A set of constraints that the IK must obey\nConstraints constraints\n\n---\n\n# The returned solution \nRobotState solution\nMoveItErrorCodes error_code\n\n";
}
