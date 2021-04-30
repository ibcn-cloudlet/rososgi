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
package be.iminds.iot.ros.joystick;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
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

import be.iminds.iot.input.joystick.api.JoystickEvent;
import be.iminds.iot.input.joystick.api.JoystickListener;
import be.iminds.iot.input.joystick.api.JoystickEvent.JoystickButton;
import be.iminds.iot.input.joystick.api.JoystickEvent.Type;
import sensor_msgs.Joy;

@Component(service = NodeMain.class)
public class JoySubscriber extends AbstractNodeMain {

	private volatile List<JoystickListener> listeners = new ArrayList<>();
	
	private Subscriber<Joy> subscriber;

	private int[] previousButtons = new int[16];
	
	@Override
	public GraphName getDefaultNodeName() {
		return GraphName.of("joy/subscriber");
	}

	@Override
	public void onStart(ConnectedNode connectedNode) {
		String topic = "/joy";
		subscriber = connectedNode.newSubscriber(topic,
				Joy._TYPE);
		subscriber.addMessageListener(new MessageListener<Joy>() {
			@Override
			public void onNewMessage(Joy joy) {
				float[] axes = joy.getAxes();
				int[] buttons = joy.getButtons();
				Type type = Type.JOYSTICK_CHANGED;
				
				for(int i=0;i<JoystickButton.values().length;i++){
					if(previousButtons[i]==0 && buttons[i] == 1){
						// button press event
						type = Type.values()[i];
					} else if(previousButtons[i]==1 && buttons[i] == 0) {
						// button release event
						type = Type.values()[i+JoystickButton.values().length];
					}
				}
				
				JoystickEvent e = new JoystickEvent(type, axes, buttons);
				for(JoystickListener l : listeners){
					try {
						l.onEvent(e);
					} catch(Throwable t) {}
				}
				
				previousButtons = buttons;
			}
		});
	}

	@Override
	public void onShutdown(Node node) {
		subscriber.shutdown();
	}

	@Reference(cardinality=ReferenceCardinality.MULTIPLE, policy=ReferencePolicy.DYNAMIC)
	synchronized void addJoystickListener(JoystickListener l, Map<String, Object> properties){
		List<JoystickListener> copy = new ArrayList<>(listeners);
		copy.add(l);
		listeners = copy;
	}
	
	synchronized void removeJoystickListener(JoystickListener l, Map<String, Object> properties){
		List<JoystickListener> copy = new ArrayList<>(listeners);
		copy.remove(l);
		listeners = copy;
	}
}
