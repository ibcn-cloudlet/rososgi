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
package mavros_msgs;

public interface FileChecksum extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/FileChecksum";
  static final java.lang.String _DEFINITION = "# FTP::Checksum\n#\n# :file_path:\tfile to calculate checksum\n# :crc32:\tfile checksum\n# :success:\tindicates success end of request\n# :r_errno:\tremote errno if applicapable\n\nstring file_path\n---\nuint32 crc32\nbool success\nint32 r_errno\n";
}
