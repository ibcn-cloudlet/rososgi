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

public interface VFR_HUD extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/VFR_HUD";
  static final java.lang.String _DEFINITION = "# Metrics typically displayed on a HUD for fixed wing aircraft\n#\n# VFR_HUD message\n\nstd_msgs/Header header\nfloat32 airspeed\t# m/s\nfloat32 groundspeed\t# m/s\nint16 heading\t\t# degrees 0..360\nfloat32 throttle\t\t# normalized to 0.0..1.0\nfloat32 altitude\t\t# MSL\nfloat32 climb\t\t# current climb rate m/s\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  float getAirspeed();
  void setAirspeed(float value);
  float getGroundspeed();
  void setGroundspeed(float value);
  short getHeading();
  void setHeading(short value);
  float getThrottle();
  void setThrottle(float value);
  float getAltitude();
  void setAltitude(float value);
  float getClimb();
  void setClimb(float value);
}
