package com.thinkify.cabApplication.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.model.Driver;
import com.thinkify.cabApplication.model.Vehicle;
import com.thinkify.cabApplication.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Override
	public boolean add_driver(Driver driver_details, Vehicle vehicle_details, Coordinate current_location) {
		if(driverMap.containsKey(driver_details.getDriverName())) {
			return false;
		}
		driver_details.setVehicle(vehicle_details);
		driver_details.setDriverLocation(current_location);
		driverMap.put(driver_details.getDriverName(), driver_details);
		return false;
	}

	@Override
	public boolean update_driverLocation(String driver_name, Coordinate new_location) {
		if(!driverMap.containsKey(driver_name)) {
			return false;
		}
		driverMap.get(driver_name).setDriverLocation(new_location);
		return true;
	}

	@Override
	public boolean change_driver_status(String driver_name, boolean status) {
		if(!driverMap.containsKey(driver_name)) {
			return false;
		}
		driverMap.get(driver_name).setAvailable(status);
		return true;
	}

	@Override
	public List<String> find_total_earning() {
		List<String> result = new ArrayList<>();
		for(Entry<String, Driver> entry : driverMap.entrySet()) {
			result.add(entry.getKey()+" earn $"+ entry.getValue().getEarnings());
		}
		return result;
	}

}
