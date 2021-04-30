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

public interface PlanningSceneComponents extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/PlanningSceneComponents";
  static final java.lang.String _DEFINITION = "# This message defines the components that make up the PlanningScene message.\n# The values can be used as a bitfield to specify which parts of the PlanningScene message\n# are of interest\n\n# Scene name, model name, model root\nuint32 SCENE_SETTINGS=1\n\n# Joint values of the robot state\nuint32 ROBOT_STATE=2\n\n# Attached objects (including geometry) for the robot state\nuint32 ROBOT_STATE_ATTACHED_OBJECTS=4\n\n# The names of the world objects\nuint32 WORLD_OBJECT_NAMES=8\n\n# The geometry of the world objects\nuint32 WORLD_OBJECT_GEOMETRY=16\n\n# The maintained octomap \nuint32 OCTOMAP=32\n\n# The maintained list of transforms\nuint32 TRANSFORMS=64\n\n# The allowed collision matrix\nuint32 ALLOWED_COLLISION_MATRIX=128\n\n# The default link padding and link scaling\nuint32 LINK_PADDING_AND_SCALING=256\n\n# The stored object colors\nuint32 OBJECT_COLORS=512\n\n# Bitfield combining options indicated above\nuint32 components\n";
  static final int SCENE_SETTINGS = 1;
  static final int ROBOT_STATE = 2;
  static final int ROBOT_STATE_ATTACHED_OBJECTS = 4;
  static final int WORLD_OBJECT_NAMES = 8;
  static final int WORLD_OBJECT_GEOMETRY = 16;
  static final int OCTOMAP = 32;
  static final int TRANSFORMS = 64;
  static final int ALLOWED_COLLISION_MATRIX = 128;
  static final int LINK_PADDING_AND_SCALING = 256;
  static final int OBJECT_COLORS = 512;
  int getComponents();
  void setComponents(int value);
}
