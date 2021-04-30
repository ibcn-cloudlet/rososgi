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
package ik_solver_service;

public interface SolvePreferredTypeIKRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "ik_solver_service/SolvePreferredTypeIKRequest";
  static final java.lang.String _DEFINITION = "bool \t\tarm_to_front\nbool \t\tarm_bended_up\nbool \t\tgripper_downwards\nfloat64[3] \tdes_position\nfloat64[3] \tdes_normal\n";
  boolean getArmToFront();
  void setArmToFront(boolean value);
  boolean getArmBendedUp();
  void setArmBendedUp(boolean value);
  boolean getGripperDownwards();
  void setGripperDownwards(boolean value);
  double[] getDesPosition();
  void setDesPosition(double[] value);
  double[] getDesNormal();
  void setDesNormal(double[] value);
}
