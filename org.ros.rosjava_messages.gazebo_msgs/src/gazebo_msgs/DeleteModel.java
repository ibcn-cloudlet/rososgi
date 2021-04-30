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
package gazebo_msgs;

public interface DeleteModel extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/DeleteModel";
  static final java.lang.String _DEFINITION = "string model_name                 # name of the Gazebo Model to be deleted\n---\nbool success                      # return true if deletion is successful\nstring status_message             # comments if available\n";
}
