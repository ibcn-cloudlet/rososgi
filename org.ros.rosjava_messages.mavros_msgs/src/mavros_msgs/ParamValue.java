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

public interface ParamValue extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/ParamValue";
  static final java.lang.String _DEFINITION = "# Parameter value storage type.\n#\n# Integer and float fields:\n#\n# if integer != 0: it is integer value\n# else if real != 0.0: it is float value\n# else: it is zero.\n\nint64 integer\nfloat64 real\n";
  long getInteger();
  void setInteger(long value);
  double getReal();
  void setReal(double value);
}
