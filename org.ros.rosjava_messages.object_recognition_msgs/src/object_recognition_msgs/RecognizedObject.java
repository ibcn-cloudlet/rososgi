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
package object_recognition_msgs;

public interface RecognizedObject extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "object_recognition_msgs/RecognizedObject";
  static final java.lang.String _DEFINITION = "##################################################### HEADER ###########################################################\n\n# The header frame corresponds to the pose frame, NOT the point_cloud frame.\nHeader header\n\n################################################## OBJECT INFO #########################################################\n\n# Contains information about the type and the position of a found object\n# Some of those fields might not be filled because the used techniques do not fill them or because the user does not\n# request them\n\n# The type of the found object\nobject_recognition_msgs/ObjectType type\n\n#confidence: how sure you are it is that object and not another one.\n# It is between 0 and 1 and the closer to one it is the better\nfloat32 confidence\n\n################################################ OBJECT CLUSTERS #######################################################\n\n# Sometimes you can extract the 3d points that belong to the object, in the frames of the original sensors\n# (it is an array as you might have several sensors)\nsensor_msgs/PointCloud2[] point_clouds\n\n# Sometimes, you can only provide a bounding box/shape, even in 3d\n# This is in the pose frame\nshape_msgs/Mesh bounding_mesh\n\n# Sometimes, you only have 2d input so you can\'t really give a pose, you just get a contour, or a box\n# The last point will be linked to the first one automatically\ngeometry_msgs/Point[] bounding_contours\n\n#################################################### POSE INFO #########################################################\n\n# This is the result that everybody expects : the pose in some frame given with the input. The units are radian/meters\n# as usual\ngeometry_msgs/PoseWithCovarianceStamped pose\n";
  std_msgs.Header getHeader();
  void setHeader(std_msgs.Header value);
  object_recognition_msgs.ObjectType getType();
  void setType(object_recognition_msgs.ObjectType value);
  float getConfidence();
  void setConfidence(float value);
  java.util.List<sensor_msgs.PointCloud2> getPointClouds();
  void setPointClouds(java.util.List<sensor_msgs.PointCloud2> value);
  shape_msgs.Mesh getBoundingMesh();
  void setBoundingMesh(shape_msgs.Mesh value);
  java.util.List<geometry_msgs.Point> getBoundingContours();
  void setBoundingContours(java.util.List<geometry_msgs.Point> value);
  geometry_msgs.PoseWithCovarianceStamped getPose();
  void setPose(geometry_msgs.PoseWithCovarianceStamped value);
}
