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

public interface FileOpen extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/FileOpen";
  static final java.lang.String _DEFINITION = "# FTP::Open\n#\n# :file_path:\tused as session id in read/write/close services\n# :size:\tfile size returned for MODE_READ\n# :success:\tindicates success end of request\n# :r_errno:\tremote errno if applicapable\n\nuint8 MODE_READ = 0\t# open for read\nuint8 MODE_WRITE = 1\t# open for write\nuint8 MODE_CREATE = 2\t# do creat()\n\nstring file_path\nuint8 mode\n---\nuint32 size\nbool success\nint32 r_errno\n";
}
