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

public interface BodyRequestRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/BodyRequestRequest";
  static final java.lang.String _DEFINITION = "string body_name   # name of the body requested. body names are prefixed by model name, e.g. pr2::base_link\n";
  java.lang.String getBodyName();
  void setBodyName(java.lang.String value);
}
