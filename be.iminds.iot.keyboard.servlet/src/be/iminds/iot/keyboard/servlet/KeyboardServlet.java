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
package be.iminds.iot.keyboard.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.HttpService;

import be.iminds.iot.input.keyboard.api.KeyboardEvent;
import be.iminds.iot.input.keyboard.api.KeyboardEvent.Type;
import be.iminds.iot.input.keyboard.api.KeyboardListener;

@Component(service = { javax.servlet.Servlet.class }, 
	    property = { "alias:String=/keyboard/servlet",
					 "osgi.http.whiteboard.servlet.pattern=/keyboard/servlet", 
				     "aiolos.proxy=false" }, 
		immediate = true)
public class KeyboardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<KeyboardListener> listeners = new ArrayList<>();
	
	@Reference(cardinality=ReferenceCardinality.MULTIPLE, policy=ReferencePolicy.DYNAMIC)
	synchronized void addKeyboardListener(KeyboardListener l, Map<String, Object> properties){
		List<KeyboardListener> copy = new ArrayList<>(listeners);
		copy.add(l);
		listeners = copy;
	}
	
	synchronized void removeKeyboardListener(KeyboardListener l, Map<String, Object> properties){
		List<KeyboardListener> copy = new ArrayList<>(listeners);
		copy.remove(l);
		listeners = copy;
	}
	
	@Reference
	void setHttpService(HttpService http) {
		try {
			// TODO How to register resources with whiteboard pattern?
			http.registerResources("/keyboard", "res", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KeyboardEvent.Type type = request.getParameter("type").equals("keydown") ? Type.PRESSED : Type.RELEASED;
		String key = request.getParameter("key");
		if(key==null){
			// on chrome you only get code?!
			// use code instead or convert to key or pass both?!
			String code = request.getParameter("code");
			if(code.startsWith("Key")){
				key = code.substring(3).toLowerCase();
			} else if(code.startsWith("Digit")){
				key = code.substring(5).toLowerCase();
			} else {
				key = code;
			}
		}
		
		for(KeyboardListener l : listeners){
			try {
				l.onEvent(new KeyboardEvent(type, key));
			} catch(Throwable t) {}
		}
		
		response.getWriter().close();
	}

}
