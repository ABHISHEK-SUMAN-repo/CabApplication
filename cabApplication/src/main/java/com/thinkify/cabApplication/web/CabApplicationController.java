package com.thinkify.cabApplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkify.cabApplication.exceptions.InvalidInputException;
import com.thinkify.cabApplication.exceptions.NotFoundException;
import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.service.DriverService;
import com.thinkify.cabApplication.service.UserServive;

@RestController
@RequestMapping("/app/v1")
public class CabApplicationController {
	
	@Autowired
	private UserServive userservice;
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/update_userLocation")
	public String update_userLocation(@RequestParam String username, @RequestParam String coordinate) {
		
		coordinate = coordinate.replace('(', ' ').replace(')',' ').trim();
		String[] ch = coordinate.split(",");
		username = username.trim();
		
		if(ch.length<2) {
			throw new InvalidInputException("invalid path variable values");
		}
		
		Coordinate newCordCoordinate = new Coordinate(Integer.parseInt(ch[0]), Integer.parseInt(ch[1]));
		if(!userservice.update_userLocation(username, newCordCoordinate)) {
			throw new NotFoundException(username+" not registered");
		}
		return "updated";
	}
	
	
	@GetMapping("/update_driverLocation")
	public String update_driverLocation(@RequestParam String drivername, @RequestParam String coordinate) {
		
		coordinate = coordinate.replace('(', ' ').replace(')',' ').trim();
		String[] ch = coordinate.split(",");
		drivername = drivername.trim();
		
		if(ch.length<2) {
			throw new InvalidInputException("invalid path variable values");
		}
		
		Coordinate newCordCoordinate = new Coordinate(Integer.parseInt(ch[0]), Integer.parseInt(ch[1]));
		if(!driverService.update_driverLocation(drivername, newCordCoordinate)) {
			throw new NotFoundException(drivername+" not available");
		}
		
		return "updated";
	}

}
