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

public interface StreamRateRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/StreamRateRequest";
  static final java.lang.String _DEFINITION = "# sets stream rate\n# See REQUEST_DATA_STREAM message\n\nuint8 STREAM_ALL = 0\nuint8 STREAM_RAW_SENSORS = 1\nuint8 STREAM_EXTENDED_STATUS = 2\nuint8 STREAM_RC_CHANNELS = 3\nuint8 STREAM_RAW_CONTROLLER = 4\nuint8 STREAM_POSITION = 6\nuint8 STREAM_EXTRA1 = 10\nuint8 STREAM_EXTRA2 = 11\nuint8 STREAM_EXTRA3 = 12\n\nuint8 stream_id\nuint16 message_rate\nbool on_off\n";
  static final byte STREAM_ALL = 0;
  static final byte STREAM_RAW_SENSORS = 1;
  static final byte STREAM_EXTENDED_STATUS = 2;
  static final byte STREAM_RC_CHANNELS = 3;
  static final byte STREAM_RAW_CONTROLLER = 4;
  static final byte STREAM_POSITION = 6;
  static final byte STREAM_EXTRA1 = 10;
  static final byte STREAM_EXTRA2 = 11;
  static final byte STREAM_EXTRA3 = 12;
  byte getStreamId();
  void setStreamId(byte value);
  short getMessageRate();
  void setMessageRate(short value);
  boolean getOnOff();
  void setOnOff(boolean value);
}
