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

public interface OpticalFlowRad extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/OpticalFlowRad";
  static final java.lang.String _DEFINITION = "# OPTICAL_FLOW_RAD message data\r\n\r\nstd_msgs/Header header\r\n\r\nuint32 integration_time_us\r\nfloat32 integrated_x\r\nfloat32 integrated_y\r\nfloat32 integrated_xgyro\r\nfloat32 integrated_ygyro\r\nfloat32 integrated_zgyro\r\nint16 temperature\r\nuint8 quality\r\nuint32 time_delta_distance_us\r\nfloat32 distance\r\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  int getIntegrationTimeUs();
  void setIntegrationTimeUs(int value);
  float getIntegratedX();
  void setIntegratedX(float value);
  float getIntegratedY();
  void setIntegratedY(float value);
  float getIntegratedXgyro();
  void setIntegratedXgyro(float value);
  float getIntegratedYgyro();
  void setIntegratedYgyro(float value);
  float getIntegratedZgyro();
  void setIntegratedZgyro(float value);
  short getTemperature();
  void setTemperature(short value);
  byte getQuality();
  void setQuality(byte value);
  int getTimeDeltaDistanceUs();
  void setTimeDeltaDistanceUs(int value);
  float getDistance();
  void setDistance(float value);
}
