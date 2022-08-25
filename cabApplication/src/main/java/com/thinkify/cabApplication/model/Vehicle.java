package com.thinkify.cabApplication.model;

public class Vehicle {
	
	private  String vehicleName;
	
	private String vehicleNumber;

	public Vehicle(String vehicleName, String vehicleNumber) {
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"vehicleName='" + vehicleName + '\'' +
				", vehicleNumber='" + vehicleNumber + '\'' +
				'}';
	}
}
