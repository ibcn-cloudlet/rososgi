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

public interface ListControllers extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "controller_manager_msgs/ListControllers";
  static final java.lang.String _DEFINITION = "# The ListControllers service returns a list of controller names/states/types of the\n# controllers that are loaded inside the controller_manager.\n\n---\nControllerState[] controller\n";
}
