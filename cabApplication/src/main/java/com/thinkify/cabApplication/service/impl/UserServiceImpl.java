package com.thinkify.cabApplication.service.impl;

import org.springframework.stereotype.Service;

import com.thinkify.cabApplication.model.ContactDetails;
import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.model.User;
import com.thinkify.cabApplication.service.UserServive;

@Service
public class UserServiceImpl implements UserServive{

	@Override
	public boolean add_user(User user) {
		if(userMap.containsKey(user.getUserName())) {
			return false;
		}
		userMap.put(user.getUserName(), user);
		return true;
	}

	@Override
	public boolean update_user(String userName, ContactDetails newContactDetails) {
		if(!userMap.containsKey(userName)) {
			return false;
		}
		userMap.get(userName).setContactDetails(newContactDetails);
		return true;
	}

	@Override
	public boolean update_userLocation(String userName, Coordinate location) {
		if(!userMap.containsKey(userName)) {
			return false;
		}
		userMap.get(userName).setUserLocation(location);
		return true;
	}

}
