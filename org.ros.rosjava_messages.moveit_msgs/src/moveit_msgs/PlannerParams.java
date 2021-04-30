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

public interface PlannerParams extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlannerParams";
  static final java.lang.String _DEFINITION = "# parameter names (same size as values)\nstring[] keys\n\n# parameter values (same size as keys)\nstring[] values\n\n# parameter description (can be empty)\nstring[] descriptions\n";
  java.util.List<java.lang.String> getKeys();
  void setKeys(java.util.List<java.lang.String> value);
  java.util.List<java.lang.String> getValues();
  void setValues(java.util.List<java.lang.String> value);
  java.util.List<java.lang.String> getDescriptions();
  void setDescriptions(java.util.List<java.lang.String> value);
}
