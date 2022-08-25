package com.thinkify_labs.cabApplication.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.utils.CabAppUtil;

public class CabAppUtilTest {

	@Test
	public void calculateDistanceByFormula_thenCorrect() {
		
		int x1 = 3;
	    int y1 = 4;
	    int x2 = 7;
	    int y2 = 1;
		
		Coordinate c1 = new Coordinate(x1, y1);
		Coordinate c2 = new Coordinate(x2, y2);
		
	    double distance = CabAppUtil.calculateDistance(c1, c2);

	    assertEquals(distance, 5, 0.001);
	}
}
