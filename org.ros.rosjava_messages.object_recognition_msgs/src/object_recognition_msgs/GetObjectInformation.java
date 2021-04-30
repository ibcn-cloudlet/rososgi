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

public interface GetObjectInformation extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "object_recognition_msgs/GetObjectInformation";
  static final java.lang.String _DEFINITION = "# Retrieve extra data from the DB for a given object\n\n# The type of the object to retrieve info from\nobject_recognition_msgs/ObjectType type\n\n---\n\n# Extra object info \nobject_recognition_msgs/ObjectInformation information\n";
}
