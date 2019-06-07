package com.java.parkinglot.model;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.Map;	
import java.util.SortedSet;
import java.util.TreeSet;

public class ParkingLot {

	private int capacity = 0;
	private Map<Integer, VehicleParked> areaMap;
	private Map<String, LinkedList<Integer>> colorMap;
	private SortedSet<Integer> freeSlot;
	
	
	private static ParkingLot parkingLot = null;
		
	private ParkingLot(int capacity) {

		this.capacity = capacity;
		freeSlot = new TreeSet<Integer>();
		colorMap = new HashMap<String, LinkedList<Integer>>();
		if (capacity>0) {
			this.areaMap = new HashMap<Integer, VehicleParked>(capacity);
			System.out.println("Parking lot Created with capacity of "+capacity);
		}
	}

	//Getter-Setter
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Map<Integer, VehicleParked> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(Map<Integer, VehicleParked> areaMap) {
		this.areaMap = areaMap;
	}

	public SortedSet<Integer> getFreeSlot() {
		return freeSlot;
	}

	public void setFreeSlot(SortedSet<Integer> freeSlot) {
		this.freeSlot = freeSlot;
	}
	
	
	public Map<String, LinkedList<Integer>> getColorMap() {
		return colorMap;
	}


	public void setColorMap(Map<String, LinkedList<Integer>> colorMap) {
		this.colorMap = colorMap;
	}


	public static ParkingLot createParkingLot(int capacity) {
		if(parkingLot != null) {
			System.out.println("Parking Lot is already existing with the capacity of : " + parkingLot.getCapacity());
			return parkingLot;
		} else {
			parkingLot = 
					new ParkingLot(capacity);
			return parkingLot;
		}

	}
	
	 public synchronized static ParkingLot resetTheInstance(){
		 
		 if(parkingLot != null) {
			 parkingLot=null;
		}
		 return null;
	} 
}
