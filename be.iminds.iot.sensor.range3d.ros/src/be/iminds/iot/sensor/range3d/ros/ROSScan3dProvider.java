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
package be.iminds.iot.sensor.range3d.ros;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;
import org.ros.node.topic.Subscriber;

import be.iminds.iot.sensor.api.PointCloud;
import be.iminds.iot.sensor.api.Scanner3D;
import be.iminds.iot.sensor.api.SensorListener;
import be.iminds.iot.sensor.api.SensorValue;
import sensor_msgs.PointCloud2;

/**
 * Subscribes to a point cloud topic and exposes this to OSGi
 * 
 * @author tverbele
 *
 */
@Component(service = NodeMain.class,
	name="be.iminds.iot.sensor.range3d.ros.Scanner3D",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class ROSScan3dProvider extends AbstractNodeMain implements Scanner3D {

	private static class PointField {
		String name;
		int offset;
		int datatype;
		int size;
		int count;
	}
	
	private BundleContext context;
	private ServiceRegistration<Scanner3D> registration;
	
	private volatile List<SensorListener> listeners = new ArrayList<>();

	private String name;
	private String topic;
	private String[] fieldNames;
	private PointField[] fields;
	
	private Dictionary<String, Object> properties = new Hashtable<>();

	private UUID id = UUID.randomUUID();
	private volatile PointCloud current = null;
	
	private Subscriber<PointCloud2> subscriber;
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of(name.replaceAll("( )|#", "_")+"/subscriber");
	}

	@Override
	public void onStart(ConnectedNode connectedNode) {
		subscriber = connectedNode.newSubscriber(topic, PointCloud2._TYPE);
		subscriber.addMessageListener(new MessageListener<PointCloud2>() {
			@Override
			public void onNewMessage(PointCloud2 pc) {
				PointCloud pointCloud = new PointCloud();
				pointCloud.src = id;
				pointCloud.size = pc.getWidth();
				
				// parse fields
				if(fields == null) {
					fieldNames = new String[pc.getFields().size()];
					fieldNames = pc.getFields().stream().map(f -> f.getName()).collect(Collectors.toList()).toArray(fieldNames);
					
					fields = new PointField[pc.getFields().size()];
					fields = pc.getFields().stream().map(f -> {
						PointField field = new PointField();
						field.name = f.getName();
						field.count = f.getCount();
						field.datatype = f.getDatatype();
						if(field.datatype <=2) {
							field.size = 1;
						} else if(field.datatype <=4) {
							field.size = 2;
						} else if(field.datatype <=7) {
							field.size = 4;
						} else {
							field.size = 8;
						}
						field.offset = f.getOffset();
						return field;
					}).collect(Collectors.toList()).toArray(fields);

				}
				pointCloud.fields = fieldNames;
				
				// parse data
				
				ByteBuffer data = ByteBuffer.wrap(pc.getData().array()).order(pc.getIsBigendian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
				pointCloud.data = new float[fields.length*pointCloud.size];

				// skip initial offset
				for(int i=0;i<pc.getData().arrayOffset();i++) {
					data.get();
				}
				
				int pointstep = pc.getPointStep();
				int k = 0;
				for(int i=0;i<pointCloud.size;i++) {
					int index = 0;
					for(PointField f : fields) {
						// offset
						while(index < f.offset) {
							data.get();
							index++;
						}
						
						for(int c=0;c<f.count;c++) {
							switch(f.datatype) {
							case 1:
								pointCloud.data[k] = (float) data.get();
								break;
							case 2:
								pointCloud.data[k] = (float)(0xFF & data.get());
								break;
							case 3:
								pointCloud.data[k] = (float) data.getShort();
								break;
							case 4:
								pointCloud.data[k] = (float) (0xFF & data.getShort());
								break;	
							case 5: 
							case 6:
								// can we handle UINT32?
								pointCloud.data[k] = (float) data.getInt();
								break;
							case 7:
								pointCloud.data[k] = data.getFloat();
								break;
							case 8:
								pointCloud.data[k] = (float) data.getDouble();
								break;
							}
							
							index+=f.size;
		
							k++;
						}
					}
					
					// skip tailing padding
					while(index < pointstep) {
						data.get();
						index++;
					}
				}
				
				if(current == null){
					// register Scanner3D service
					registration = context.registerService(Scanner3D.class, ROSScan3dProvider.this, properties);
				}
				current = pointCloud;
				
				for(SensorListener l : listeners){
					l.update(current);
				}
			}
		});
	}


	@Override
	public void onShutdown(Node node) {
		if(registration != null){
			registration.unregister();
			current = null;
		}
		
		subscriber.shutdown();
	}
	
	@Override
	public SensorValue getValue() {
		return current;
	}


	@Override
	public String[] getFields() {
		return current.fields;
	}
	
	
	@Reference(cardinality=ReferenceCardinality.MULTIPLE, policy=ReferencePolicy.DYNAMIC)
	synchronized void addSensorListener(SensorListener l, Map<String, Object> properties){
		String[] tt = new String[0];
		Object target = properties.get("target");
		if(target instanceof String){
			String t = (String)target;
			if(t.contains(",")){
				tt = t.split(",");
			} else {
				tt = new String[]{t};
			}
		} else if( target instanceof String[]){
			tt = (String[]) target;
		}
		
		boolean filter = true;
		for(String t : tt){
			if(t.equals("*") || t.equals(id.toString())){
				filter = false;
				break;
			}
		}
		
		if(!filter){
			List<SensorListener> copy = new ArrayList<>(listeners);
			copy.add(l);
			listeners = copy;
		}
	}
	
	synchronized void removeSensorListener(SensorListener l, Map<String, Object> properties){
		List<SensorListener> copy = new ArrayList<>(listeners);
		copy.remove(l);
		listeners = copy;
	}
	
	@Activate
	void activate(BundleContext context, Map<String, Object> config){
		this.context = context;
		this.name = (String)config.get("name");
		this.topic = (String)config.get("topic");
		this.properties.put("id", id.toString());
		config.entrySet().forEach(e -> this.properties.put(e.getKey(), e.getValue().toString()));
	}
}
