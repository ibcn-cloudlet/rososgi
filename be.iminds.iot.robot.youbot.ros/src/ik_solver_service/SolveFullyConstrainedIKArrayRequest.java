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

public interface SolveFullyConstrainedIKArrayRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "ik_solver_service/SolveFullyConstrainedIKArrayRequest";
  static final java.lang.String _DEFINITION = "FullyConstrainedReq[] ikarray\n";
  java.util.List<ik_solver_service.FullyConstrainedReq> getIkarray();
  void setIkarray(java.util.List<ik_solver_service.FullyConstrainedReq> value);
}
