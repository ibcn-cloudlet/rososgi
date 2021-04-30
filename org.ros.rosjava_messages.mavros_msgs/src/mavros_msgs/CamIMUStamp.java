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

public interface CamIMUStamp extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/CamIMUStamp";
  static final java.lang.String _DEFINITION = "# IMU-Camera synchronisation data\n\ntime frame_stamp\t\t# Timestamp when the camera was triggered\nint32 frame_seq_id\t\t# Sequence number of the image frame\n";
  org.ros.message.Time getFrameStamp();
  void setFrameStamp(org.ros.message.Time value);
  int getFrameSeqId();
  void setFrameSeqId(int value);
}
