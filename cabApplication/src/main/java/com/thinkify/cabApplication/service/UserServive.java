package com.thinkify.cabApplication.service;

import com.thinkify.cabApplication.model.ContactDetails;
import com.thinkify.cabApplication.model.Coordinate;
import com.thinkify.cabApplication.model.User;

public interface UserServive extends BaseService {
	
	boolean add_user(User user);
	
	boolean update_user(String userName, ContactDetails userContactDetails);
	
	boolean update_userLocation(String userName, Coordinate location);
	
}
