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

public interface CartesianWrench extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "brics_actuator/CartesianWrench";
  static final java.lang.String _DEFINITION = "time timeStamp\nPoison poisonStamp\nstring base_frame_uri\nstring target_frame_uri\n# need some more frames?\t\nCartesianVector force\nCartesianVector torque\t\n";
  org.ros.message.Time getTimeStamp();
  void setTimeStamp(org.ros.message.Time value);
  brics_actuator.Poison getPoisonStamp();
  void setPoisonStamp(brics_actuator.Poison value);
  java.lang.String getBaseFrameUri();
  void setBaseFrameUri(java.lang.String value);
  java.lang.String getTargetFrameUri();
  void setTargetFrameUri(java.lang.String value);
  brics_actuator.CartesianVector getForce();
  void setForce(brics_actuator.CartesianVector value);
  brics_actuator.CartesianVector getTorque();
  void setTorque(brics_actuator.CartesianVector value);
}
