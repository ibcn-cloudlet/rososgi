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
package franka_msgs;

public interface FrankaState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "franka_msgs/FrankaState";
  static final java.lang.String _DEFINITION = "std_msgs/Header header\nfloat64[6] cartesian_collision\nfloat64[6] cartesian_contact\nfloat64[7] q\nfloat64[7] q_d\nfloat64[7] dq\nfloat64[7] dq_d\nfloat64[7] tau_J\nfloat64[7] dtau_J\nfloat64[6] K_F_ext_hat_K\nfloat64[2] elbow\nfloat64[2] elbow_d\nfloat64[7] joint_collision\nfloat64[7] joint_contact\nfloat64[6] O_F_ext_hat_K\nfloat64[7] tau_ext_hat_filtered\nfloat64 m_load\nfloat64[3] F_x_Cload\nfloat64[9] I_load\nfloat64[16] O_T_EE\nfloat64[16] O_T_EE_d\nfloat64[16] F_T_EE\nfloat64[16] EE_T_K\nfloat64 time\nfranka_msgs/Errors current_errors\nfranka_msgs/Errors last_motion_errors\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  double[] getCartesianCollision();
  void setCartesianCollision(double[] value);
  double[] getCartesianContact();
  void setCartesianContact(double[] value);
  double[] getQ();
  void setQ(double[] value);
  double[] getQD();
  void setQD(double[] value);
  double[] getDq();
  void setDq(double[] value);
  double[] getDqD();
  void setDqD(double[] value);
  double[] getTauJ();
  void setTauJ(double[] value);
  double[] getDtauJ();
  void setDtauJ(double[] value);
  double[] getKFExtHatK();
  void setKFExtHatK(double[] value);
  double[] getElbow();
  void setElbow(double[] value);
  double[] getElbowD();
  void setElbowD(double[] value);
  double[] getJointCollision();
  void setJointCollision(double[] value);
  double[] getJointContact();
  void setJointContact(double[] value);
  double[] getOFExtHatK();
  void setOFExtHatK(double[] value);
  double[] getTauExtHatFiltered();
  void setTauExtHatFiltered(double[] value);
  double getMLoad();
  void setMLoad(double value);
  double[] getFXCload();
  void setFXCload(double[] value);
  double[] getILoad();
  void setILoad(double[] value);
  double[] getOTEE();
  void setOTEE(double[] value);
  double[] getOTEED();
  void setOTEED(double[] value);
  double[] getFTEE();
  void setFTEE(double[] value);
  double[] getEETK();
  void setEETK(double[] value);
  double getTime();
  void setTime(double value);
  franka_msgs.Errors getCurrentErrors();
  void setCurrentErrors(franka_msgs.Errors value);
  franka_msgs.Errors getLastMotionErrors();
  void setLastMotionErrors(franka_msgs.Errors value);
}
