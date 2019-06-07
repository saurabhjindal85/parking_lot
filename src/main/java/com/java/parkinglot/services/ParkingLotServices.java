package com.java.parkinglot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.java.parkinglot.model.ParkingLot;
import com.java.parkinglot.model.VehicleParked;

public class ParkingLotServices {
	
	private ParkingLot parkingLot;
	
	public ParkingLotServices( ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	public void resetTheInstance() {
		parkingLot = ParkingLot.resetTheInstance();
	}
	//Park Vehicle
	public void addVehicle(VehicleParked vehicleParked) {
		int parkingLocation = -1;
		if(parkingLot.getAreaMap().size()== parkingLot.getCapacity() && parkingLot.getFreeSlot().size()==0) {
			System.out.println("Parking space is full");
			return;
		}
		if(parkingLot.getAreaMap().size() !=0) {
			if(parkingLot.getFreeSlot().size()==0) {
				parkingLocation = parkingLot.getAreaMap().size()+1;
				vehicleParked.setParkingLocation(parkingLocation);
				parkingLot.getAreaMap().put(parkingLocation, vehicleParked);
			}else {
				parkingLocation = parkingLot.getFreeSlot().first();
				parkingLot.getAreaMap().put(parkingLot.getFreeSlot().first(), vehicleParked);
				parkingLot.getFreeSlot().remove(parkingLocation);
			}
		}else if(parkingLot.getAreaMap().size() < parkingLot.getCapacity() && parkingLot.getAreaMap().size()==0) {
			parkingLot.getAreaMap().put(1, vehicleParked);
			parkingLocation =1;
		}
		addToColorMap( vehicleParked, parkingLocation);
		
		if(parkingLocation > 0) 
			System.out.println("Vehicle " + vehicleParked.getRegNumber() + " parked at "+ parkingLocation);
		else
			System.out.println("Parking space is full");

	}
	
	//adding to the colorMap
	private void addToColorMap( VehicleParked vehicleParked, int parkingLocation ) {
		LinkedList<Integer> slot = null;
		parkingLocation = parkingLocation > 0 ? parkingLocation: 1;
		if(parkingLot.getColorMap().keySet().contains(vehicleParked.getcolour())) {
			slot = parkingLot.getColorMap().get(vehicleParked.getcolour());
			slot.add(parkingLocation);
		}else {
			slot = new LinkedList<Integer>();
			slot.add(parkingLocation);
			parkingLot.getColorMap().put(vehicleParked.getcolour(), slot);
		}
	}
	
	
	//Vehicle leaving
	public void CarLeaving(int parkingLocation) {
		if(parkingLocation > parkingLot.getCapacity() || parkingLocation == 0) {
			System.out.println( "Invalid Parking location");
		}else {
			Set<Integer> locationOfVehicleParked = parkingLot.getAreaMap().keySet();
			if(locationOfVehicleParked.contains(parkingLocation) && parkingLot.getAreaMap().get(parkingLocation)!=null) {
				VehicleParked vehicleLeft =parkingLot.getAreaMap().get(parkingLocation) ;
				parkingLot.getFreeSlot().add(parkingLocation);
				parkingLot.getAreaMap().put(parkingLocation, null);
				removingFromColorMap(vehicleLeft);
				System.out.println( "Car parked at location "+ parkingLocation+" left");
			}else {
				System.out.println("No vehicle is parked at the given location");
			}
		}
	}
	
	public void removingFromColorMap(VehicleParked vehicleLeft) {
		Set<String> color = parkingLot.getColorMap().keySet();
		if(color.contains(vehicleLeft.getcolour())) {
			LinkedList<Integer> slots = parkingLot.getColorMap().get(vehicleLeft.getcolour());
			if(slots.size() == 1) {
				parkingLot.getColorMap().remove(vehicleLeft.getcolour(), Arrays.asList(vehicleLeft.getParkingLocation()));
			}else {
				slots.remove(vehicleLeft.getParkingLocation());
				parkingLot.getColorMap().put(vehicleLeft.getcolour(), slots);
			}
		}
	}
	
	//Parking Status
	public void getStatus() {
		//System.out.println(areaMap);
		if(parkingLot==null) {
			System.out.println("Parking Lot is not created or initialize, create one using Create cmd");
			return;
		}
		TreeMap<Integer, VehicleParked> treeMap = new TreeMap(parkingLot.getAreaMap());
		if(treeMap.size()==0) {
			System.out.println("No car in parking Lot");
			return ;
		}
		treeMap.forEach((k,v)-> {
			if(v!=null) {
				System.out.println(k +". Vehicle reg No. "+ v.getRegNumber() + " and Colour : " + v.getcolour());
			}else {
				System.out.println(k);
			}
		});
	}
	
	//registration_numbers_for_cars_with_colour White 
	public List<Integer> searchColour(String colour) { 
		List<VehicleParked> list = new ArrayList<VehicleParked>();
		if(parkingLot.getColorMap().get(colour) != null) {
			return parkingLot.getColorMap().get(colour);
		}else 
			return null;
	}
	
	public void getRegNumberFromColor(String colour) { 
		List<Integer> list = searchColour(colour);
		if(list!=null) {
			list.forEach(l -> {
				VehicleParked parked =  parkingLot.getAreaMap().get(l);
				System.out.print(parked.getRegNumber() + " ");
			});
			System.out.println();
		}else {
			System.out.println("No car in Parking lot of this colour");
		}
	}
	
	//search for Registration number
	public void searchRegNo(String regNo) {
		int[] slot = {-1};
		parkingLot.getAreaMap().forEach((k,v)->{
			if(v!=null && regNo.equals(v.getRegNumber())) {
				slot[0]= v.getParkingLocation();
				}
			});
		if(slot[0]>0) {
			System.out.println("Slot number : "+ slot[0] +". Vehicle reg No. "+ regNo);
		}else {
			System.out.println("Vehicle not parked in this Parking");
		}
	}
}
