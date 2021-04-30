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

public interface OverrideRCIn extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/OverrideRCIn";
  static final java.lang.String _DEFINITION = "# Override RC Input\n# Currently MAVLink defines override for 8 channel\n\nuint16 CHAN_RELEASE=0\nuint16 CHAN_NOCHANGE=65535\n\nuint16[8] channels\n";
  static final short CHAN_RELEASE = 0;
  static final short CHAN_NOCHANGE = -1;
  short[] getChannels();
  void setChannels(short[] value);
}
