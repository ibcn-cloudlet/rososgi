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

public interface JointControllerState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "control_msgs/JointControllerState";
  static final java.lang.String _DEFINITION = "Header header\nfloat64 set_point\nfloat64 process_value\nfloat64 process_value_dot\nfloat64 error\nfloat64 time_step\nfloat64 command\nfloat64 p\nfloat64 i\nfloat64 d\nfloat64 i_clamp\n\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  double getSetPoint();
  void setSetPoint(double value);
  double getProcessValue();
  void setProcessValue(double value);
  double getProcessValueDot();
  void setProcessValueDot(double value);
  double getError();
  void setError(double value);
  double getTimeStep();
  void setTimeStep(double value);
  double getCommand();
  void setCommand(double value);
  double getP();
  void setP(double value);
  double getI();
  void setI(double value);
  double getD();
  void setD(double value);
  double getIClamp();
  void setIClamp(double value);
}
