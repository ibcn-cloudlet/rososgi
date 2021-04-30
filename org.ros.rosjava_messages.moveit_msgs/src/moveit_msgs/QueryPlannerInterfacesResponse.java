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

public interface QueryPlannerInterfacesResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/QueryPlannerInterfacesResponse";
  static final java.lang.String _DEFINITION = "\n# The planning instances that could be used in the benchmark\nPlannerInterfaceDescription[] planner_interfaces";
  java.util.List<moveit_msgs.PlannerInterfaceDescription> getPlannerInterfaces();
  void setPlannerInterfaces(java.util.List<moveit_msgs.PlannerInterfaceDescription> value);
}
