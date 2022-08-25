package com.thinkify.cabApplication.model;

import java.util.Objects;

public class Driver {
	
	private String driverName;
	private Gender gender;
	private int age;
	private Vehicle vehicle;
	private Coordinate driverLocation;
	private boolean available;
	private int earnings;
	
	public Driver(String driverName, Gender gender, int age) {
		this.driverName = driverName;
		this.gender = gender;
		this.age = age;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
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
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Coordinate getDriverLocation() {
		return driverLocation;
	}
	public void setDriverLocation(Coordinate driverLocation) {
		this.driverLocation = driverLocation;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public int getEarnings() {
		return earnings;
	}
	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, driverName, gender);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return age == other.age && Objects.equals(driverName, other.driverName) && gender == other.gender;
	}
	
	
	

}
