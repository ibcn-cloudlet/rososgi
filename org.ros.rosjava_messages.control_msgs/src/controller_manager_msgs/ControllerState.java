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
package controller_manager_msgs;

public interface ControllerState extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "controller_manager_msgs/ControllerState";
  static final java.lang.String _DEFINITION = "string name\nstring state\nstring type\nstring hardware_interface\nstring[] resources\n";
  java.lang.String getName();
  void setName(java.lang.String value);
  java.lang.String getState();
  void setState(java.lang.String value);
  java.lang.String getType();
  void setType(java.lang.String value);
  java.lang.String getHardwareInterface();
  void setHardwareInterface(java.lang.String value);
  java.util.List<java.lang.String> getResources();
  void setResources(java.util.List<java.lang.String> value);
}
