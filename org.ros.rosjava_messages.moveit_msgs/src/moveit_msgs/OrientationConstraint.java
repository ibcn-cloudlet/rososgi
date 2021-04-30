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
package moveit_msgs;

public interface OrientationConstraint extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/OrientationConstraint";
  static final java.lang.String _DEFINITION = "# This message contains the definition of an orientation constraint.\n\nHeader header\n\n# The desired orientation of the robot link specified as a quaternion\ngeometry_msgs/Quaternion orientation\n\n# The robot link this constraint refers to\nstring link_name\n\n# optional axis-angle error tolerances specified\nfloat64 absolute_x_axis_tolerance\nfloat64 absolute_y_axis_tolerance\nfloat64 absolute_z_axis_tolerance\n\n# A weighting factor for this constraint (denotes relative importance to other constraints. Closer to zero means less important)\nfloat64 weight\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  geometry_msgs.Quaternion getOrientation();
  void setOrientation(geometry_msgs.Quaternion value);
  java.lang.String getLinkName();
  void setLinkName(java.lang.String value);
  double getAbsoluteXAxisTolerance();
  void setAbsoluteXAxisTolerance(double value);
  double getAbsoluteYAxisTolerance();
  void setAbsoluteYAxisTolerance(double value);
  double getAbsoluteZAxisTolerance();
  void setAbsoluteZAxisTolerance(double value);
  double getWeight();
  void setWeight(double value);
}
