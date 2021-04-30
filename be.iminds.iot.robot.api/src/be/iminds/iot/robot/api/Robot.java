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
package be.iminds.iot.robot.api;

import java.util.concurrent.CountDownLatch;

import org.osgi.util.promise.Deferred;
import org.osgi.util.promise.Promise;

import be.iminds.iot.robot.api.Robot;

public interface Robot<T extends Robot<T>> {

	Promise<T> waitFor(long time);

	default Promise<T> waitFor(Promise<?> condition){
		final Deferred<T> d = new Deferred<T>();
		condition.then( p -> d.resolveWith(waitFor(0)), p -> d.fail(p.getFailure()));
		return d.getPromise();
	}
	
	default Promise<T> waitFor(Promise<?>... conditions){
		final Deferred<T> d = new Deferred<T>();
		final CountDownLatch latch = new CountDownLatch(conditions.length);
		for(Promise<?> condition : conditions){
			condition.then(p -> {
				latch.countDown();
				if(latch.getCount()==0){
					d.resolveWith(waitFor(0));
				}
				return null;
			}, p -> d.fail(p.getFailure()));
		}
		return d.getPromise();
	}
	
	// rename of the waitFor, results in nicer chaining
	// robot.move().until().then(p -> ...)
	default Promise<T> until(Promise<?> condition){
		return waitFor(condition);
	}
	
	default Promise<T> until(Promise<?>... conditions){
		return waitFor(conditions);
	}
	
	Promise<T> stop();
	
}
