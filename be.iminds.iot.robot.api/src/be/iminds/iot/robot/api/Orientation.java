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

public class Orientation {

	public float x;
	public float y;
	public float z;
	public float w;

	public Orientation(){}
	
	public Orientation(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Orientation(float[] mat) {
		// 3x3 Rotation matrix
		if(mat.length < 9)
			throw new RuntimeException("Rotation matrix should be 3x3");

		float tr = mat[0] + mat[4] + mat[8];

		if (tr > 0) {
			float S = (float) Math.sqrt(tr + 1.0) * 2; // S=4*qw
			w = 0.25f * S;
			x = (mat[7] - mat[5]) / S;
			y = (mat[2] - mat[6]) / S;
			z = (mat[3] - mat[1]) / S;
		} else if ((mat[0] > mat[4]) & (mat[0] > mat[8])) {
			float S = (float) Math.sqrt(1.0 + mat[0] - mat[4] - mat[8]) * 2; // S=4*qx
			w = (mat[7] - mat[5]) / S;
			x = 0.25f * S;
			y = (mat[1] + mat[3]) / S;
			z = (mat[2] + mat[6]) / S;
		} else if (mat[4] > mat[8]) {
			float S = (float) Math.sqrt(1.0 + mat[4] - mat[0] - mat[8]) * 2; // S=4*qy
			w = (mat[2] - mat[6]) / S;
			x = (mat[1] + mat[3]) / S;
			y = 0.25f * S;
			z = (mat[5] + mat[7]) / S;
		} else {
			float S = (float) Math.sqrt(1.0 + mat[8] - mat[0] - mat[4]) * 2; // S=4*qz
			w = (mat[3] - mat[1]) / S;
			x = (mat[2] + mat[6]) / S;
			y = (mat[5] + mat[7]) / S;
			z = 0.25f * S;
		}
		
		if(w < 0) {
			w = -w;
		}
	}
	
	public Orientation(float yaw, float pitch, float roll) {
		double c1 = Math.cos(yaw * 0.5);
		double s1 = Math.sin(yaw * 0.5);
		double c2 = Math.cos(roll * 0.5);
		double s2 = Math.sin(roll * 0.5);
		double c3 = Math.cos(pitch * 0.5);
		double s3 = Math.sin(pitch * 0.5);
		double c1c2 = c1*c2;
		double s1s2 = s1*s2;

		w = (float) (c1c2*c3 - s1s2*s3);
  		x = (float) (c1c2*s3 + s1s2*c3);
		y = (float) (s1*c2*c3 + c1*s2*s3);
		z = (float) (c1*s2*c3 - s1*c2*s3);
	}
	
	public float[] toYPR(){
		float yaw, pitch, roll;
		double test = x*y + z*w;
		if (test > 0.499) { // singularity at north pole
			yaw = (float) (2 * Math.atan2(x,w));
			pitch =  (float) Math.PI/2;
			roll = 0.0f;
		} else if (test < -0.499) { // singularity at south pole
			yaw = (float) (-2 * Math.atan2(x,w));
			pitch = (float)-Math.PI/2;
			roll = 0.0f;
		} else {
			double sqx = x*x;
    			double sqy = y*y;
    			double sqz = z*z;
    			yaw = (float) Math.atan2(2*y*w-2*x*z , 1 - 2*sqy - 2*sqz);
			pitch = (float) Math.asin(2*test);
			roll = (float) Math.atan2(2*x*w-2*y*z , 1 - 2*sqx - 2*sqz);
		}
		float[] ypr = new float[3];
		ypr[0] = yaw;
		ypr[1] = pitch;
		ypr[2] = roll;
		return ypr;
	}

	public float[] toMat(){
		float[] mat = new float[9];
		mat[0] = 1 - 2*y*y - 2*z*z;
		mat[1] = 2*x*y - 2*z*w;
		mat[2] = 2*x*z + 2*y*w;
		mat[3] = 2*x*y + 2*z*w;
		mat[4] = 1 - 2*x*x - 2*z*z;
		mat[5] = 2*y*z - 2*x*w;
		mat[6] = 2*x*z - 2*y*w;
		mat[7] = 2*y*z + 2*x*w;
		mat[8] = 1 - 2*x*x - 2*y*y;
		return mat;
	}

	@Override
	public String toString() {
		return x+" "+y+" "+z+" "+w;
	}
}
