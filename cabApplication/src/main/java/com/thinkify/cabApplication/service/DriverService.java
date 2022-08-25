package com.thinkify.cabApplication.service;

import java.util.List;

import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.model.Driver;
import com.thinkify.cabApplication.model.Vehicle;

public interface DriverService extends BaseService {
	
	boolean add_driver(Driver driver_details, Vehicle vehicle_details, Coordinate current_location);
	
	boolean update_driverLocation(String driver_name, Coordinate new_location);
	
	boolean	change_driver_status(String driver_name, boolean status);

	List<String> find_total_earning();
}
