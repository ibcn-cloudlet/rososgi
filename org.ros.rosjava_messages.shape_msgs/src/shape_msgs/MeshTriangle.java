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

public interface MeshTriangle extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "shape_msgs/MeshTriangle";
  static final java.lang.String _DEFINITION = "# Definition of a triangle\'s vertices\nuint32[3] vertex_indices\n";
  int[] getVertexIndices();
  void setVertexIndices(int[] value);
}
