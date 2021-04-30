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

public interface LinkScale extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/LinkScale";
  static final java.lang.String _DEFINITION = "#name for the link\nstring link_name\n\n# scaling to apply to the link\nfloat64 scale\n";
  java.lang.String getLinkName();
  void setLinkName(java.lang.String value);
  double getScale();
  void setScale(double value);
}
