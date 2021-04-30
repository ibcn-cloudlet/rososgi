This repository contains OSGi bundles to interface with ROS (Robot Operating System)

The ros.core OSGi bundle will use either a natively running roscore instance, or start a new roscore instance based on the rosjava implementation. OSGi bundles can be provided to also start rosnodes that are installed on the system. This is implemented by starting an external process from within the OSGi bundle.

Robots and sensors can be exposed to the OSGi system as OSGi services. The api packages contain interfaces for various robot types and sensors. In the native world other ROS nodes can be started and connect to the system. In the OSGi world new bundles can subscribe/publish to other ROS topics and expose these as nice OSGi services.

In order to subscribe/publish to ROS topics, or call ROS services, the required messages have to be available in the Java runtime. The be.iminds.iot.ros.msgs.generator bundle can be used to generate the required Java types that can then be wrapped in an OSGi bundle. It provides a generate command that will place all generated .java files in the generated_msgs directory. Optionally one can provide a custom ROS package path with the command.
