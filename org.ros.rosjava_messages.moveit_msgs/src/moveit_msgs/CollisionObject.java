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

public interface CollisionObject extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/CollisionObject";
  static final java.lang.String _DEFINITION = "# a header, used for interpreting the poses\nHeader header\n\n# the id of the object (name used in MoveIt)\nstring id\n\n# The object type in a database of known objects\nobject_recognition_msgs/ObjectType type\n\n# the the collision geometries associated with the object;\n# their poses are with respect to the specified header\n\n# solid geometric primitives\nshape_msgs/SolidPrimitive[] primitives\ngeometry_msgs/Pose[] primitive_poses\n\n# meshes\nshape_msgs/Mesh[] meshes\ngeometry_msgs/Pose[] mesh_poses\n\n# bounding planes (equation is specified, but the plane can be oriented using an additional pose)\nshape_msgs/Plane[] planes\ngeometry_msgs/Pose[] plane_poses\n\n# Adds the object to the planning scene. If the object previously existed, it is replaced.\nbyte ADD=0\n\n# Removes the object from the environment entirely (everything that matches the specified id)\nbyte REMOVE=1\n\n# Append to an object that already exists in the planning scene. If the does not exist, it is added.\nbyte APPEND=2\n\n# If an object already exists in the scene, new poses can be sent (the geometry arrays must be left empty)\n# if solely moving the object is desired\nbyte MOVE=3\n\n# Operation to be performed\nbyte operation\n";
  static final byte ADD = 0;
  static final byte REMOVE = 1;
  static final byte APPEND = 2;
  static final byte MOVE = 3;
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  java.lang.String getId();
  void setId(java.lang.String value);
  object_recognition_msgs.ObjectType getType();
  void setType(object_recognition_msgs.ObjectType value);
  java.util.List<shape_msgs.SolidPrimitive> getPrimitives();
  void setPrimitives(java.util.List<shape_msgs.SolidPrimitive> value);
  java.util.List<geometry_msgs.Pose> getPrimitivePoses();
  void setPrimitivePoses(java.util.List<geometry_msgs.Pose> value);
  java.util.List<shape_msgs.Mesh> getMeshes();
  void setMeshes(java.util.List<shape_msgs.Mesh> value);
  java.util.List<geometry_msgs.Pose> getMeshPoses();
  void setMeshPoses(java.util.List<geometry_msgs.Pose> value);
  java.util.List<shape_msgs.Plane> getPlanes();
  void setPlanes(java.util.List<shape_msgs.Plane> value);
  java.util.List<geometry_msgs.Pose> getPlanePoses();
  void setPlanePoses(java.util.List<geometry_msgs.Pose> value);
  byte getOperation();
  void setOperation(byte value);
}
