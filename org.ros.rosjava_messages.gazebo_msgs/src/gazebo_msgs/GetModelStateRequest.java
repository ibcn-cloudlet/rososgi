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
package gazebo_msgs;

public interface GetModelStateRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/GetModelStateRequest";
  static final java.lang.String _DEFINITION = "string model_name                    # name of Gazebo Model\nstring relative_entity_name          # return pose and twist relative to this entity\n                                     # an entity can be a model, body, or geom\n                                     # be sure to use gazebo scoped naming notation (e.g. [model_name::body_name])\n                                     # leave empty or \"world\" will use inertial world frame\n";
  java.lang.String getModelName();
  void setModelName(java.lang.String value);
  java.lang.String getRelativeEntityName();
  void setRelativeEntityName(java.lang.String value);
}
