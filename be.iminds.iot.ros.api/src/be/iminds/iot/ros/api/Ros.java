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
package be.iminds.iot.ros.api;

import java.io.File;
import java.net.URI;
import java.util.Collection;
import java.util.List;

import org.ros.node.NodeMain;

public interface Ros {

	URI masterURI();
	
	String masterHost();
	
	int masterPort();
	
	String distro();
	
	String namespace();
	
	
	File root();
	
	List<File> packagePath();
	

	URI nodeURI(String node);
	
	Collection<String> nodes();
	
	Collection<String> topics();
	
	Collection<String> publishers(String topic);
	
	Collection<String> subscribers(String topic);
	
	String topicType(String topic);
	
	Collection<String> services();
	
	Collection<String> providers(String service);
	
	String env();
	
	void setParameter(String key, Object value);
	
	<T> T getParameter(String key, Class<T> type);
	
	
	void addNode(NodeMain node);
	
	void removeNode(NodeMain node);
}
