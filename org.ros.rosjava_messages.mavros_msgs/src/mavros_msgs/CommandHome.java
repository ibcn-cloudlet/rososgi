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

public interface CommandHome extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/CommandHome";
  static final java.lang.String _DEFINITION = "# request set new home position\n\nbool current_gps\nfloat32 latitude\nfloat32 longitude\nfloat32 altitude\n---\nbool success\nuint8 result\n";
}
