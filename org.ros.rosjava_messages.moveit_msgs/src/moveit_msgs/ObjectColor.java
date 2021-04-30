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

public interface ObjectColor extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/ObjectColor";
  static final java.lang.String _DEFINITION = "# The object id for which we specify color\nstring id\n\n# The value of the color\nstd_msgs/ColorRGBA color\n";
  java.lang.String getId();
  void setId(java.lang.String value);
  std_msgs.ColorRGBA getColor();
  void setColor(std_msgs.ColorRGBA value);
}
