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

public interface CommandTriggerControlRequest extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "mavros_msgs/CommandTriggerControlRequest";
  static final java.lang.String _DEFINITION = "# Type for controlling onboard camera trigerring system\n\nbool    trigger_enable\t\t# Trigger on/off control\nfloat32 integration_time\t# Shutter integration time. Zero to use current onboard value.\n";
  boolean getTriggerEnable();
  void setTriggerEnable(boolean value);
  float getIntegrationTime();
  void setIntegrationTime(float value);
}
