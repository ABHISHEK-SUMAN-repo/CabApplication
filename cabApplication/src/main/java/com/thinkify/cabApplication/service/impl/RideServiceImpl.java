package com.thinkify.cabApplication.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.thinkify.cabApplication.exceptions.NotFoundException;
import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.model.Driver;
import com.thinkify.cabApplication.service.RideService;
import com.thinkify.cabApplication.utils.CabAppUtil;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService{

	@Override
	public Map<String, Integer> find_ride(String username, Coordinate source, Coordinate destination) {
		
		if(!userMap.containsKey(username)) {
			throw new NotFoundException(username +" not registered.");
		}
		
		Map<String, Integer> availableDrivers = new HashMap<>();
		
		for(Entry<String, Driver> entry : driverMap.entrySet()) {
			if(CabAppUtil.calculateDistance(source, entry.getValue().getDriverLocation())<=5 && entry.getValue().isAvailable()) {
				availableDrivers.put(entry.getValue().getDriverName(), CabAppUtil.calculateDistance(source, destination));
			}
		}
		
		return availableDrivers;
	}

	@Override
	public int choose_ride(String username, String drive_name, Map<String, Integer> availableDrivers) {
		if(!userMap.containsKey(username)) {
			throw new NotFoundException(username +" not registered.");
		}
		
		if(!availableDrivers.containsKey(drive_name)) {
			throw new NotFoundException(drive_name +" not available.");
		}
		this.startRide(drive_name);
		return availableDrivers.get(drive_name);
	}

	@Override
	public int calculateBill(String username, String drive_name, int price) {
		if(!userMap.containsKey(username)) {
			throw new NotFoundException(username +" not registered.");
		}
		int temp = driverMap.get(drive_name).getEarnings();
		driverMap.get(drive_name).setEarnings(temp+price);
		return price;
	}
	
	private void startRide(String driverName) {
		driverMap.get(driverName).setAvailable(false);
		System.out.println("ride Started");
	}

}
