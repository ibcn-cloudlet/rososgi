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

public interface Mavlink extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/Mavlink";
  static final java.lang.String _DEFINITION = "# Mavlink message transport type.\n#\n# Used to transport mavlink_message_t via ROS topic\n#\n# :is_valid: flag meaning that there CRC16 error or message is unknown by libmavconn.\n#            You may simply drop all non valid messages. Used for GCS Bridge to transport\n#            unknown messages.\n#\n# Please use mavros_msgs::mavlink::convert() from <mavros_msgs/mavlink_convert.h>\n# to convert between ROS and MAVLink message type\n\nstd_msgs/Header header\nbool is_valid\n\nuint8 len\nuint8 seq\nuint8 sysid\nuint8 compid\nuint8 msgid\nuint16 checksum\nuint64[] payload64\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  boolean getIsValid();
  void setIsValid(boolean value);
  byte getLen();
  void setLen(byte value);
  byte getSeq();
  void setSeq(byte value);
  byte getSysid();
  void setSysid(byte value);
  byte getCompid();
  void setCompid(byte value);
  byte getMsgid();
  void setMsgid(byte value);
  short getChecksum();
  void setChecksum(short value);
  long[] getPayload64();
  void setPayload64(long[] value);
}
