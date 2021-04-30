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

public interface ConstraintEvalResult extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/ConstraintEvalResult";
  static final java.lang.String _DEFINITION = "# This message contains result from constraint evaluation\n# result specifies the result of constraint evaluation \n# (true indicates state satisfies constraint, false indicates state violates constraint)\n# if false, distance specifies a measure of the distance of the state from the constraint\n# if true, distance is set to zero\nbool result\nfloat64 distance\n";
  boolean getResult();
  void setResult(boolean value);
  double getDistance();
  void setDistance(double value);
}
