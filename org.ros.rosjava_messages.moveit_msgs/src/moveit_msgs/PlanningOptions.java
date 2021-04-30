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

public interface PlanningOptions extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlanningOptions";
  static final java.lang.String _DEFINITION = "\n# The diff to consider for the planning scene (optional)\nPlanningScene planning_scene_diff\n\n# If this flag is set to true, the action\n# returns an executable plan in the response but does not attempt execution  \nbool plan_only\n\n# If this flag is set to true, the action of planning &\n# executing is allowed to look around  (move sensors) if\n# it seems that not enough information is available about\n# the environment\nbool look_around\n\n# If this value is positive, the action of planning & executing\n# is allowed to look around for a maximum number of attempts;\n# If the value is left as 0, the default value is used, as set\n# with dynamic_reconfigure\nint32 look_around_attempts\n\n# If set and if look_around is true, this value is used as\n# the maximum cost allowed for a path to be considered executable.\n# If the cost of a path is higher than this value, more sensing or \n# a new plan needed. If left as 0.0 but look_around is true, then \n# the default value set via dynamic_reconfigure is used\nfloat64 max_safe_execution_cost\n\n# If the plan becomes invalidated during execution, it is possible to have\n# that plan recomputed and execution restarted. This flag enables this\n# functionality \nbool replan\n\n# The maximum number of replanning attempts \nint32 replan_attempts\n\n# The amount of time to wait in between replanning attempts (in seconds)\nfloat64 replan_delay\n";
  moveit_msgs.PlanningScene getPlanningSceneDiff();
  void setPlanningSceneDiff(moveit_msgs.PlanningScene value);
  boolean getPlanOnly();
  void setPlanOnly(boolean value);
  boolean getLookAround();
  void setLookAround(boolean value);
  int getLookAroundAttempts();
  void setLookAroundAttempts(int value);
  double getMaxSafeExecutionCost();
  void setMaxSafeExecutionCost(double value);
  boolean getReplan();
  void setReplan(boolean value);
  int getReplanAttempts();
  void setReplanAttempts(int value);
  double getReplanDelay();
  void setReplanDelay(double value);
}
