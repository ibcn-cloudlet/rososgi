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
package octomap_msgs;

public interface GetOctomapResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "octomap_msgs/GetOctomapResponse";
  static final java.lang.String _DEFINITION = "octomap_msgs/Octomap map";
  octomap_msgs.Octomap getMap();
  void setMap(octomap_msgs.Octomap value);
}
