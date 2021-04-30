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
package brics_actuator;

public interface Poison extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "brics_actuator/Poison";
  static final java.lang.String _DEFINITION = "string originator \t\t# node id\nstring description \t\t# encoding still an issue\nfloat32 qos\t\t\t# reliability of the channel\n\t\t\t\t# 0..1 where 1 means healthy\n";
  java.lang.String getOriginator();
  void setOriginator(java.lang.String value);
  java.lang.String getDescription();
  void setDescription(java.lang.String value);
  float getQos();
  void setQos(float value);
}
