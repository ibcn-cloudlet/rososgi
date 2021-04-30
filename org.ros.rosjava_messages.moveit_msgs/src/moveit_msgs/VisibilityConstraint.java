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

public interface VisibilityConstraint extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "moveit_msgs/VisibilityConstraint";
  static final java.lang.String _DEFINITION = "# The constraint is useful to maintain visibility to a disc (the target) in a particular frame.\n# This disc forms the base of a visibiliy cone whose tip is at the origin of the sensor.\n# Maintaining visibility is done by ensuring the robot does not obstruct the visibility cone.\n# Note:\n# This constraint does NOT enforce minimum or maximum distances between the sensor\n# and the target, nor does it enforce the target to be in the field of view of\n# the sensor. A PositionConstraint can (and probably should) be used for such purposes.\n\n# The radius of the disc that should be maintained visible \nfloat64 target_radius\n\n# The pose of the disc; as the robot moves, the pose of the disc may change as well\n# This can be in the frame of a particular robot link, for example\ngeometry_msgs/PoseStamped target_pose\n\n# From the sensor origin towards the target, the disc forms a visibility cone\n# This cone is approximated using many sides. For example, when using 4 sides, \n# that in fact makes the visibility region be a pyramid.\n# This value should always be 3 or more.\nint32 cone_sides\n\n# The pose in which visibility is to be maintained.\n# The frame id should represent the robot link to which the sensor is attached.\n# It is assumed the sensor can look directly at the target, in any direction.\n# This assumption is usually not true, but additional PositionConstraints\n# can resolve this issue.\ngeometry_msgs/PoseStamped sensor_pose\n\n# Even though the disc is maintained visible, the visibility cone can be very small\n# because of the orientation of the disc with respect to the sensor. It is possible\n# for example to view the disk almost from a side, in which case the visibility cone \n# can end up having close to 0 volume. The view angle is defined to be the angle between\n# the normal to the visibility disc and the direction vector from the sensor origin.\n# The value below represents the minimum desired view angle. For a perfect view,\n# this value will be 0 (the two vectors are exact opposites). For a completely obstructed view\n# this value will be Pi/2 (the vectors are perpendicular). This value defined below \n# is the maximum view angle to be maintained. This should be a value in the open interval\n# (0, Pi/2). If 0 is set, the view angle is NOT enforced.\nfloat64 max_view_angle\n\n# This angle is used similarly to max_view_angle but limits the maximum angle\n# between the sensor origin direction vector and the axis that connects the\n# sensor origin to the target frame origin. The value is again in the range (0, Pi/2)\n# and is NOT enforced if set to 0.\nfloat64 max_range_angle\n\n# The axis that is assumed to indicate the direction of view for the sensor\n# X = 2, Y = 1, Z = 0\nuint8 SENSOR_Z=0\nuint8 SENSOR_Y=1\nuint8 SENSOR_X=2\nuint8 sensor_view_direction\n\n# A weighting factor for this constraint (denotes relative importance to other constraints. Closer to zero means less important)\nfloat64 weight\n";
  static final byte SENSOR_Z = 0;
  static final byte SENSOR_Y = 1;
  static final byte SENSOR_X = 2;
  double getTargetRadius();
  void setTargetRadius(double value);
  geometry_msgs.PoseStamped getTargetPose();
  void setTargetPose(geometry_msgs.PoseStamped value);
  int getConeSides();
  void setConeSides(int value);
  geometry_msgs.PoseStamped getSensorPose();
  void setSensorPose(geometry_msgs.PoseStamped value);
  double getMaxViewAngle();
  void setMaxViewAngle(double value);
  double getMaxRangeAngle();
  void setMaxRangeAngle(double value);
  byte getSensorViewDirection();
  void setSensorViewDirection(byte value);
  double getWeight();
  void setWeight(double value);
}
