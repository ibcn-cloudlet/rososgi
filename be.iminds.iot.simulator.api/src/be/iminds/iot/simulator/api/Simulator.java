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
package be.iminds.iot.simulator.api;

import java.util.Map;
import java.util.concurrent.TimeoutException;

public interface Simulator {

	/**
	 * Start simulator at 10 Hz in non synchronized mode (no tick call required)
	 */
	default public void start(){
		start(false, 0.1f, null);
	}

	/**
	 * Start simulator at 10 Hz
	 * @param sync set to true to control simulator ticks
	 */
	default public void start(boolean sync) {
		start(sync, 0.1f, null);
	}
	

	/**
	 * Start the simulator
	 * @param sync set to true to control simulator ticks
	 * @param step time (in seconds) to advance the simulator each tick
	 */
	default void start(boolean sync, float step){
		start(sync, step, null);
	}
	
	/**
	 * Start the simulator
	 * @param sync set to true to control simulator ticks
	 * @param step time (in seconds) to advance the simulator each tick
	 * @param properties additional configuration properties for the simulator
	 */
	void start(boolean sync, float step, Map<String, Object> properties);
	
	/**
	 * Pause simulation
	 */
	void pause();
	
	/**
	 * Resume simulation when paused
	 */
	void resume();
	
	/**
	 * Stop simulation
	 */
	void stop();
	
	/**
	 * Advance simulation with one tick, only applies when started with sync=true
	 * @throws TimeoutException
	 */
	void tick() throws TimeoutException;
	
	/**
	 * Load scene into the simulator
	 * @param file the scene file to load
	 */
	default void loadScene(String file){
		loadScene(file, null);
	}
	
	/**
	 * Load scene into the simulator
	 * @param file the scene file to load
	 * @param config additional properties
	 */
	void loadScene(String file, Map<String, String> config);
	
	/**
	 * Get position of a simulation object
	 * @param object the object identifier in the simulator
	 * @return the absolute position of the object
	 */
	Position getPosition(String object);
	
	/**
	 * Set the position of a simulation object
	 * @param object the object identifier in the simulator
	 * @param p the desired absolute position of the object
	 */
	void setPosition(String object, Position p);
	
	/**
	 * Get the position of a simulation object relative to another object
	 * @param object the object identifier in the simulator
	 * @param relativeTo the object identifier of the object in who's coordinate frame the position is desired
	 * @return the relative position of object relative to another object
	 */
	Position getPosition(String object, String relativeTo);
	
	/**
	 * Set the position of a simulation object relative to another object
	 * @param object the object identifier in the simulator
	 * @param relativeTo the object identifier of the object in who's coordinate frame the position is desired
	 * @param p the desired relative position of object relative to another object
	 */
	void setPosition(String object, String relativeTo, Position p);
	
	/**
	 * Get orientation of a simulation object
	 * @param object the object identifier in the simulator
	 * @return the absolute orientation of the object
	 */
	Orientation getOrientation(String object);
	
	/**
	 * Set the orientation of a simulation object
	 * @param object the object identifier in the simulator
	 * @param o the desired absolute orientation of the object
	 */
	void setOrientation(String object, Orientation o);
	
	/**
	 * Get the orientation of a simulation object relative to another object
	 * @param object the object identifier in the simulator
	 * @param relativeTo the object identifier of the object in who's coordinate frame the orientation is desired
	 * @return the relative orientation of object relative to another object
	 */
	Orientation getOrientation(String object, String relativeTo);
	
	/**
	 * Set the orientation of a simulation object relative to another object
	 * @param object the object identifier in the simulator
	 * @param relativeTo the object identifier of the object in who's coordinate frame the orientation is desired
	 * @param o the desired relative orientation of object relative to another object
	 */
	void setOrientation(String object, String relativeTo, Orientation o);
	
	/**
	 * Set the pose of a simulation object
	 * @param object the object identifier in the simulator
	 * @param p desired absolute position
	 * @param o desired absolute orientation
	 */
	void setPose(String object, Position p, Orientation o);
	
	/**
	 * Set the pose of a simulation object relative to another object
	 * @param object the object identifier in the simulator
	 * @param relativeTo the object identifier of the object in who's coordinate frame the pose is desired
	 * @param p the desired relative position of object relative to another object
	 * @param o the desired relative orientation of object relative to another object
	 */
	void setPose(String object, String relativeTo, Position p, Orientation o);
	
	// check collisions
	/**
	 * Check collisions of a certain object
	 * @param object the object for which to check collisions
	 * @return whether or not this object is colliding
	 */
	boolean checkCollisions(String object);
	
	/**
	 * Set a simulator property
	 * 
	 * implementation depends on the simulator
	 * @param key
	 * @param value
	 */
	void setProperty(String key, Object value);
	
	/**
	 * Get a simulator property
	 * 
	 * implementation depends on the simulator
	 * @param key
	 * @return
	 */
	Object getProperty(String key);

}
