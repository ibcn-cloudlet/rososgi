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
package std_srvs;

public interface Trigger extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "std_srvs/Trigger";
  static final java.lang.String _DEFINITION = "---\nbool success   # indicate successful run of triggered service\nstring message # informational, e.g. for error messages\n";
}
