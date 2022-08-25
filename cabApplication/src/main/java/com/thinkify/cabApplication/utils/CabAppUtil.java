package com.thinkify.cabApplication.utils;

import com.thinkify.cabApplication.model.Coordinate;

public class CabAppUtil {

	public static int calculateDistance(Coordinate c1, Coordinate c2) {
		
		double x1 = c1.getX();
		double y1 = c1.getY(); 
		double x2 = c2.getX(); 
		double y2 = c2.getY();

		return (int) Math.ceil(Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)));
	}
}
