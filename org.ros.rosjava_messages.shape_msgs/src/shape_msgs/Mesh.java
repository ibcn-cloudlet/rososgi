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
package shape_msgs;

public interface Mesh extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "shape_msgs/Mesh";
  static final java.lang.String _DEFINITION = "# Definition of a mesh\n\n# list of triangles; the index values refer to positions in vertices[]\nMeshTriangle[] triangles\n\n# the actual vertices that make up the mesh\ngeometry_msgs/Point[] vertices\n";
  java.util.List<shape_msgs.MeshTriangle> getTriangles();
  void setTriangles(java.util.List<shape_msgs.MeshTriangle> value);
  java.util.List<geometry_msgs.Point> getVertices();
  void setVertices(java.util.List<geometry_msgs.Point> value);
}
