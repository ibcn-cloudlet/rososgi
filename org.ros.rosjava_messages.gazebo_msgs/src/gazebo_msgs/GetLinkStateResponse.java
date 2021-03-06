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

public interface GetLinkStateResponse extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "gazebo_msgs/GetLinkStateResponse";
  static final java.lang.String _DEFINITION = "gazebo_msgs/LinkState link_state\nbool success              # return true if get info is successful\nstring status_message     # comments if available";
  gazebo_msgs.LinkState getLinkState();
  void setLinkState(gazebo_msgs.LinkState value);
  boolean getSuccess();
  void setSuccess(boolean value);
  java.lang.String getStatusMessage();
  void setStatusMessage(java.lang.String value);
}
