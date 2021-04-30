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

public interface SetJointTrajectory extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/SetJointTrajectory";
  static final java.lang.String _DEFINITION = "string model_name\ntrajectory_msgs/JointTrajectory joint_trajectory\ngeometry_msgs/Pose model_pose\nbool set_model_pose\nbool disable_physics_updates # defaults to false\n---\nbool success                # return true if set wrench successful\nstring status_message       # comments if available\n";
}
