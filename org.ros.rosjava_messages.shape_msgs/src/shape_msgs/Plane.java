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
package shape_msgs;

public interface Plane extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "shape_msgs/Plane";
  static final java.lang.String _DEFINITION = "# Representation of a plane, using the plane equation ax + by + cz + d = 0\n\n# a := coef[0]\n# b := coef[1]\n# c := coef[2]\n# d := coef[3]\n\nfloat64[4] coef\n";
  double[] getCoef();
  void setCoef(double[] value);
}
