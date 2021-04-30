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

public interface JointPositions extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "brics_actuator/JointPositions";
  static final java.lang.String _DEFINITION = "Poison poisonStamp\nJointValue[] positions\n";
  brics_actuator.Poison getPoisonStamp();
  void setPoisonStamp(brics_actuator.Poison value);
  java.util.List<brics_actuator.JointValue> getPositions();
  void setPositions(java.util.List<brics_actuator.JointValue> value);
}
