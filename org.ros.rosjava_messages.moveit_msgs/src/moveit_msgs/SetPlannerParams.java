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

public interface SetPlannerParams extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/SetPlannerParams";
  static final java.lang.String _DEFINITION = "# Name of planning config\nstring planner_config\n\n# Optional name of planning group (set global defaults if empty)\nstring group\n\n# parameters as key-value pairs\nPlannerParams params\n\n# replace params or augment existing ones?\nbool replace\n\n---\n\n";
}
