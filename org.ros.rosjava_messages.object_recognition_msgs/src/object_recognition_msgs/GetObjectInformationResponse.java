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

public interface GetObjectInformationResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "object_recognition_msgs/GetObjectInformationResponse";
  static final java.lang.String _DEFINITION = "\n# Extra object info \nobject_recognition_msgs/ObjectInformation information";
  object_recognition_msgs.ObjectInformation getInformation();
  void setInformation(object_recognition_msgs.ObjectInformation value);
}
