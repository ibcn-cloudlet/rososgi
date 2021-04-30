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
package brics_actuator;

public interface JointConstraint extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "brics_actuator/JointConstraint";
  static final java.lang.String _DEFINITION = "string type  \t\t#smaller, greater, equal or <, >, =\nJointValue value\n";
  java.lang.String getType();
  void setType(java.lang.String value);
  brics_actuator.JointValue getValue();
  void setValue(brics_actuator.JointValue value);
}
