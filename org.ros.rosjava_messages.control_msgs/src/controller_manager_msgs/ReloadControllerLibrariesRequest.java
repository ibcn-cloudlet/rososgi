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

public interface ReloadControllerLibrariesRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "controller_manager_msgs/ReloadControllerLibrariesRequest";
  static final java.lang.String _DEFINITION = "# The ReloadControllerLibraries service will reload all controllers that are available in\n# the system as plugins\n\n\n# Reloading libraries only works if there are no controllers loaded. If there\n# are still some controllers loaded, the reloading will fail.\n# If this bool is set to true, all loaded controllers will get\n# killed automatically, and the reloading can succeed.\nbool force_kill\n";
  boolean getForceKill();
  void setForceKill(boolean value);
}
