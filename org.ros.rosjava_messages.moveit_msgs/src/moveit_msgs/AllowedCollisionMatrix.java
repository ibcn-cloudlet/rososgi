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

public interface AllowedCollisionMatrix extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/AllowedCollisionMatrix";
  static final java.lang.String _DEFINITION = "# The list of entry names in the matrix\nstring[] entry_names\n\n# The individual entries in the allowed collision matrix\n# square, symmetric, with same order as entry_names\nAllowedCollisionEntry[] entry_values\n\n# In addition to the collision matrix itself, we also have \n# the default entry value for each entry name.\n\n# If the allowed collision flag is queried for a pair of names (n1, n2)\n# that is not found in the collision matrix itself, the value of\n# the collision flag is considered to be that of the entry (n1 or n2)\n# specified in the list below. If both n1 and n2 are found in the list \n# of defaults, the result is computed with an AND operation\n\nstring[] default_entry_names\nbool[] default_entry_values\n";
  java.util.List<java.lang.String> getEntryNames();
  void setEntryNames(java.util.List<java.lang.String> value);
  java.util.List<moveit_msgs.AllowedCollisionEntry> getEntryValues();
  void setEntryValues(java.util.List<moveit_msgs.AllowedCollisionEntry> value);
  java.util.List<java.lang.String> getDefaultEntryNames();
  void setDefaultEntryNames(java.util.List<java.lang.String> value);
  boolean[] getDefaultEntryValues();
  void setDefaultEntryValues(boolean[] value);
}
