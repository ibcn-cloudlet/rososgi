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

public interface CommandTOL extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/CommandTOL";
  static final java.lang.String _DEFINITION = "# Common type for Take Off and Landing\n\nfloat32 min_pitch\t# used by takeoff\nfloat32 yaw\nfloat32 latitude\nfloat32 longitude\nfloat32 altitude\n---\nbool success\nuint8 result\n";
}
