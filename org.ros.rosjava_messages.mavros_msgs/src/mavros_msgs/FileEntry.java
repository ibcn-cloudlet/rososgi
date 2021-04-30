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

public interface FileEntry extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/FileEntry";
  static final java.lang.String _DEFINITION = "# File/Dir information\n\nuint8 TYPE_FILE = 0\nuint8 TYPE_DIRECTORY = 1\n\nstring name\nuint8 type\nuint64 size\n\n# Not supported by MAVLink FTP\n#time atime\n#int32 access_flags\n";
  static final byte TYPE_FILE = 0;
  static final byte TYPE_DIRECTORY = 1;
  java.lang.String getName();
  void setName(java.lang.String value);
  byte getType();
  void setType(byte value);
  long getSize();
  void setSize(long value);
}
