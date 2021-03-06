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
package control_msgs;

public interface FollowJointTrajectoryAction extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "control_msgs/FollowJointTrajectoryAction";
  static final java.lang.String _DEFINITION = "# ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ======\n\nFollowJointTrajectoryActionGoal action_goal\nFollowJointTrajectoryActionResult action_result\nFollowJointTrajectoryActionFeedback action_feedback\n";
  control_msgs.FollowJointTrajectoryActionGoal getActionGoal();
  void setActionGoal(control_msgs.FollowJointTrajectoryActionGoal value);
  control_msgs.FollowJointTrajectoryActionResult getActionResult();
  void setActionResult(control_msgs.FollowJointTrajectoryActionResult value);
  control_msgs.FollowJointTrajectoryActionFeedback getActionFeedback();
  void setActionFeedback(control_msgs.FollowJointTrajectoryActionFeedback value);
}
