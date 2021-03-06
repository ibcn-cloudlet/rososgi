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

public interface SetJointProperties extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/SetJointProperties";
  static final java.lang.String _DEFINITION = "string joint_name                               # name of joint\ngazebo_msgs/ODEJointProperties ode_joint_config # access to ODE joint dynamics properties\n---\nbool success                                    # return true if get successful\nstring status_message                           # comments if available\n";
}
