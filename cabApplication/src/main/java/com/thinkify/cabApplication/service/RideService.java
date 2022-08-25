package com.thinkify.cabApplication.service;

import java.util.Map;
import com.thinkify.cabApplication.model.Coordinate;

public interface RideService extends BaseService{	
	
	Map<String, Integer> find_ride(String username, Coordinate source , Coordinate destination);

	int choose_ride(String username, String drive_name, Map<String, Integer> availableDrivers);
	
	int	calculateBill(String username, String drive_name,  int price);
}
