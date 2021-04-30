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

public interface ObjectType extends org.ros.internal.message.Message {
  static final java.lang.String _TYPE = "object_recognition_msgs/ObjectType";
  static final java.lang.String _DEFINITION = "################################################## OBJECT ID #########################################################\n\n# Contains information about the type of a found object. Those two sets of parameters together uniquely define an\n# object\n\n# The key of the found object: the unique identifier in the given db\nstring key\n\n# The db parameters stored as a JSON/compressed YAML string. An object id does not make sense without the corresponding\n# database. E.g., in object_recognition, it can look like: \"{\'type\':\'CouchDB\', \'root\':\'http://localhost\'}\"\n# There is no conventional format for those parameters and it\'s nice to keep that flexibility.\n# The object_recognition_core as a generic DB type that can read those fields\n# Current examples:\n# For CouchDB:\n#   type: \'CouchDB\'\n#   root: \'http://localhost:5984\'\n#   collection: \'object_recognition\'\n# For SQL household database:\n#   type: \'SqlHousehold\'\n#   host: \'wgs36\'\n#   port: 5432\n#   user: \'willow\'\n#   password: \'willow\'\n#   name: \'household_objects\'\n#   module: \'tabletop\'\nstring db\n";
  java.lang.String getKey();
  void setKey(java.lang.String value);
  java.lang.String getDb();
  void setDb(java.lang.String value);
}
