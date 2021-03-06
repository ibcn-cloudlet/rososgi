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

public interface GripperCommandAction extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "control_msgs/GripperCommandAction";
  static final java.lang.String _DEFINITION = "# ====== DO NOT MODIFY! AUTOGENERATED FROM AN ACTION DEFINITION ======\n\nGripperCommandActionGoal action_goal\nGripperCommandActionResult action_result\nGripperCommandActionFeedback action_feedback\n";
  control_msgs.GripperCommandActionGoal getActionGoal();
  void setActionGoal(control_msgs.GripperCommandActionGoal value);
  control_msgs.GripperCommandActionResult getActionResult();
  void setActionResult(control_msgs.GripperCommandActionResult value);
  control_msgs.GripperCommandActionFeedback getActionFeedback();
  void setActionFeedback(control_msgs.GripperCommandActionFeedback value);
}
