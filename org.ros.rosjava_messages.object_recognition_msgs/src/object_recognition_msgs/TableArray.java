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
package object_recognition_msgs;

public interface TableArray extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "object_recognition_msgs/TableArray";
  static final java.lang.String _DEFINITION = "Header header\n\n# Just an array of tables\nobject_recognition_msgs/Table[] tables\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  java.util.List<object_recognition_msgs.Table> getTables();
  void setTables(java.util.List<object_recognition_msgs.Table> value);
}
