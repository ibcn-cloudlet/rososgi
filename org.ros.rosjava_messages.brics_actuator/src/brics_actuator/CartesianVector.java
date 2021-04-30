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

public interface CartesianVector extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "brics_actuator/CartesianVector";
  static final java.lang.String _DEFINITION = "string unit\nfloat64 x\nfloat64 y\nfloat64 z\n";
  java.lang.String getUnit();
  void setUnit(java.lang.String value);
  double getX();
  void setX(double value);
  double getY();
  void setY(double value);
  double getZ();
  void setZ(double value);
}
