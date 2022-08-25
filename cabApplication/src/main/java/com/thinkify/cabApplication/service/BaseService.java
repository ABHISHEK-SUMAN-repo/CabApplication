package com.thinkify.cabApplication.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.thinkify.cabApplication.model.Driver;
import com.thinkify.cabApplication.model.User;

public interface BaseService {

	Map<String , User> userMap = new ConcurrentHashMap<>();
	
	Map<String , Driver> driverMap = new ConcurrentHashMap<>();
}
