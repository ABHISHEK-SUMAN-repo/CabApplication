package com.thinkify.cabApplication.model;

public class User {
	
	private String userName;
	private Gender gender;
	private int age;
	private ContactDetails contactDetails;
	private Coordinate userLocation;
	
	public User(String userName, Gender gender, int age) {
		this.userName = userName;
		this.gender = gender;
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	public Coordinate getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(Coordinate userLocation) {
		this.userLocation = userLocation;
	}
	
	

}
