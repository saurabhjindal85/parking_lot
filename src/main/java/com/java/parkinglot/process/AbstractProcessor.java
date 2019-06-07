package com.java.parkinglot.process;

import java.util.List;

import com.java.parkinglot.constants.Command;
import com.java.parkinglot.model.ParkingLot;
import com.java.parkinglot.model.VehicleParked;
import com.java.parkinglot.services.ParkingLotServices;

public abstract class AbstractProcessor {


	ParkingLot parkingLot = null;
	ParkingLotServices parkingLotServices = null;
	
	public void validateAndProcess(String inputString) throws Exception {
		
		String[] inputStrArr = inputString.split(" ");
		if(inputStrArr[0].equals("")) {
			System.out.println("Thanks for using the program");
			return;
		}
		Command command = Command.findByName(inputStrArr[0]);
		
		if(command == null) {
			System.out.println("Invalid command");
			return;
		}
		
		switch(command) {
		case CREATE:
			if(inputStrArr.length != 2) {
				throw new Exception("Invalid no of arguments for command : " + command);
			} 
			int capacity = Integer.parseInt(inputStrArr[1]);
			parkingLot = ParkingLot.createParkingLot(capacity);
			parkingLotServices = new ParkingLotServices(parkingLot);
			break;
		case PARK:
			if(parkingLotServices == null || inputStrArr.length != 3) {
				throw new Exception("Invalid no of arguments for command : " + command);
			} 
			String regNo = inputStrArr[1];
			String color = inputStrArr[2];
			parkingLotServices.addVehicle(new VehicleParked(regNo, color, 0));
			break;
		case LEAVE:
			if( parkingLotServices == null || inputStrArr.length != 2  ) {
				throw new Exception("Invalid command : " + command);
			} 
			int parkingLocation = Integer.parseInt(inputStrArr[1]);
			parkingLotServices.CarLeaving(parkingLocation);
			break;
		case STATUS:
			if(parkingLotServices == null || inputStrArr.length != 1 ) {
				throw new Exception("Invalid command : " + command);
			}
			parkingLotServices.getStatus();
			break;
		case FETCH_SLOT_FROM_COLOR:
			if(parkingLotServices == null || inputStrArr.length != 2) {
				throw new Exception("Invalid command : " + command);
			}
			List<Integer>list = parkingLotServices.searchColour(inputStrArr[1]);  //color
			if (list != null && list.size() > 0) {
				list.forEach(l -> System.out.print(l + " "));
				System.out.println();
			} else
				System.out.println("No car in Parking lot of this colour");
			break;
		case FETCH_CARE_FROM_COLOR:
			if(parkingLotServices == null || inputStrArr.length != 2) {
				throw new Exception("Invalid command : " + command);
			}
			parkingLotServices.getRegNumberFromColor(inputStrArr[1]);  //color
			break;
		case FETCH_SLOT_FROM_REG_NO:
			if(parkingLotServices == null || inputStrArr.length != 2 ) {
				throw new Exception("Invalid command : " + command);
			}
			parkingLotServices.searchRegNo(inputStrArr[1]);  //regNo
			break;
		case EXIT:
			System.exit(0);
		}
		
	}
	
	public abstract void process() throws Exception;

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ParkingLotServices getParkingLotServices() {
		return parkingLotServices;
	}

	public void setParkingLotServices(ParkingLotServices parkingLotServices) {
		this.parkingLotServices = parkingLotServices;
	}
	
}
