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

public interface PidState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "control_msgs/PidState";
  static final java.lang.String _DEFINITION = "Header header\nduration timestep\nfloat64 error\nfloat64 error_dot\nfloat64 p_error\nfloat64 i_error\nfloat64 d_error\nfloat64 p_term\nfloat64 i_term\nfloat64 d_term\nfloat64 i_max\nfloat64 i_min\nfloat64 output\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  org.ros.message.Duration getTimestep();
  void setTimestep(org.ros.message.Duration value);
  double getError();
  void setError(double value);
  double getErrorDot();
  void setErrorDot(double value);
  double getPError();
  void setPError(double value);
  double getIError();
  void setIError(double value);
  double getDError();
  void setDError(double value);
  double getPTerm();
  void setPTerm(double value);
  double getITerm();
  void setITerm(double value);
  double getDTerm();
  void setDTerm(double value);
  double getIMax();
  void setIMax(double value);
  double getIMin();
  void setIMin(double value);
  double getOutput();
  void setOutput(double value);
}
