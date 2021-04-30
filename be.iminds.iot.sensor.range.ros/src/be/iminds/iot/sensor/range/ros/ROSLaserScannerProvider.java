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
package be.iminds.iot.sensor.range.ros;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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

import be.iminds.iot.sensor.api.LaserScanner;
import be.iminds.iot.sensor.api.SensorListener;
import be.iminds.iot.sensor.api.SensorValue;
import sensor_msgs.LaserScan;

@Component(service = NodeMain.class,
	name="be.iminds.iot.sensor.range.ros.LaserScanner",
	configurationPolicy=ConfigurationPolicy.REQUIRE)
public class ROSLaserScannerProvider extends AbstractNodeMain implements LaserScanner {

	private BundleContext context;
	private ServiceRegistration<LaserScanner> registration;
	
	private volatile List<SensorListener> listeners = new ArrayList<>();

	private String name;
	private String topic;
	private UUID id;
	private volatile be.iminds.iot.sensor.api.LaserScan currentScan = null;
	
	private Subscriber<LaserScan> subscriber;
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("laserscan/subscriber/"+name.replaceAll("( )|#", "_"));
	}

	@Override
	public void onStart(ConnectedNode connectedNode) {
		subscriber = connectedNode.newSubscriber(topic,
				LaserScan._TYPE);
		subscriber.addMessageListener(new MessageListener<LaserScan>() {
			@Override
			public void onNewMessage(LaserScan scan) {
				be.iminds.iot.sensor.api.LaserScan s = new be.iminds.iot.sensor.api.LaserScan();
				s.src = id;
				s.minAngle = scan.getAngleMin();
				s.maxAngle = scan.getAngleMax();
				s.minRange = scan.getRangeMin();
				s.maxRange = scan.getRangeMax();
				s.data = scan.getRanges();
				for(int i = 0;i<s.data.length;i++){
					if(Float.isNaN(s.data[i])){
						// convert NaN to 0
						s.data[i] = 0.0f;
					} else if(Float.isInfinite(s.data[i])){
						// convert infinite to range max
						s.data[i] = s.maxRange;
					}
				}
				
				if(currentScan == null){
					currentScan = s;

					// register LaserScanner service
					Dictionary<String, Object> properties = new Hashtable<>();
					properties.put("id", id.toString());
					properties.put("name", name);
					registration = context.registerService(LaserScanner.class, ROSLaserScannerProvider.this, properties);
				} else {
					currentScan = s;
				}
				
				for(SensorListener l : listeners){
					l.update(currentScan);
				}
			}
		});
	}

	@Override
	public SensorValue getValue() {
		return currentScan;
	}
	
	@Override
	public float getMinAngle() {
		return currentScan.minAngle;
	}

	@Override
	public float getMaxAngle() {
		return currentScan.maxAngle;
	}

	@Override
	public float getMinRange() {
		return currentScan.minRange;
	}
	
	@Override
	public float getMaxRange() {
		return currentScan.maxRange;
	}
	
	@Override
	public void onShutdown(Node node) {
		if(registration != null){
			registration.unregister();
			currentScan = null;
		}
		if(subscriber != null){
			subscriber.shutdown();
		}
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
		this.name = config.get("name").toString();
		if(name == null){
			Random r = new Random(System.currentTimeMillis());
			name = "LaserScanner-"+r.nextInt(100);
		}
		if(config.containsKey("topic")){
			topic = config.get("topic").toString();
		} else {
			topic = "/"+name.replaceAll("( )|#", "_").toLowerCase()+"/scan";
		}
		
		this.id = UUID.nameUUIDFromBytes(name.getBytes());
	}

}
