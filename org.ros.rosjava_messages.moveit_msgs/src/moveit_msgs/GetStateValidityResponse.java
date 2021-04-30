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

public interface GetStateValidityResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/GetStateValidityResponse";
  static final java.lang.String _DEFINITION = "\nbool valid\nContactInformation[] contacts\nCostSource[] cost_sources\nConstraintEvalResult[] constraint_result";
  boolean getValid();
  void setValid(boolean value);
  java.util.List<moveit_msgs.ContactInformation> getContacts();
  void setContacts(java.util.List<moveit_msgs.ContactInformation> value);
  java.util.List<moveit_msgs.CostSource> getCostSources();
  void setCostSources(java.util.List<moveit_msgs.CostSource> value);
  java.util.List<moveit_msgs.ConstraintEvalResult> getConstraintResult();
  void setConstraintResult(java.util.List<moveit_msgs.ConstraintEvalResult> value);
}
