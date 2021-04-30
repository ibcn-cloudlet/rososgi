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
package control_msgs;

public interface QueryTrajectoryStateResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "control_msgs/QueryTrajectoryStateResponse";
  static final java.lang.String _DEFINITION = "string[] name\nfloat64[] position\nfloat64[] velocity\nfloat64[] acceleration";
  java.util.List<java.lang.String> getName();
  void setName(java.util.List<java.lang.String> value);
  double[] getPosition();
  void setPosition(double[] value);
  double[] getVelocity();
  void setVelocity(double[] value);
  double[] getAcceleration();
  void setAcceleration(double[] value);
}
