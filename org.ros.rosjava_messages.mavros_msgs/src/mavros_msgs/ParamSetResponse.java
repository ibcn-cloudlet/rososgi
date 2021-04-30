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
package mavros_msgs;

public interface ParamSetResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/ParamSetResponse";
  static final java.lang.String _DEFINITION = "bool success\nmavros_msgs/ParamValue value";
  boolean getSuccess();
  void setSuccess(boolean value);
  mavros_msgs.ParamValue getValue();
  void setValue(mavros_msgs.ParamValue value);
}
