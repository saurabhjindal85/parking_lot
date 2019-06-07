package com.java.parkinglot.model;

public class VehicleParked {
	
	private String regNumber;
	private String colour;
	private int parkingLocation;
	
	public VehicleParked(String regNumber, String colour, int parkingLocation) {
		this.regNumber = regNumber;
		this.colour = colour;
		this.parkingLocation = parkingLocation;
	}
	
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getcolour() {
		return colour;
	}
	public void setcolour(String colour) {
		this.colour = colour;
	}
	public int getParkingLocation() {
		return parkingLocation;
	}
	public void setParkingLocation(int parkingLocation) {
		this.parkingLocation = parkingLocation;
	}
	
}
