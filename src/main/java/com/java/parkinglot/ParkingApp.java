package com.java.parkinglot;


import java.util.Scanner;


import com.java.parkinglot.process.AbstractProcessor;
import com.java.parkinglot.process.CommandLineProcessor;
import com.java.parkinglot.process.FileProcessor;

//INPUTS
/*create_parking_lot 6 
park KA-01-HH-1234 White 
park KA-01-HH-9999 White 
park KA-01-BB-0001 Black 
park KA-01-HH-7777 Red 
park KA-01-HH-2701 Blue 
park KA-01-HH-3141 Black 
leave 4 status 
park KA-01-P-333 White 
park DL-12-AA-9999 White 
registration_numbers_for_cars_with_colour White 
slot_numbers_for_cars_with_colour White 
slot_number_for_registration_number KA-01-HH-3141 
slot_number_for_registration_number MH-04-AY-111*/

public class ParkingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AbstractProcessor processor = null;
				Scanner sc = null;
			System.out.println("Please enter the command for creating and using ParkingLot App!!");
			if (args.length > 0) {
				String inputFileName = args[0];
				processor = new FileProcessor(inputFileName);
			} else {
				processor= new CommandLineProcessor();
				
			}
			processor.process();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	String line = sc.nextLine();
		String[] cmd = line.split(" ");
		
		ParkingLot parkingLot = null;
		
		
		//parking Lot creation 
		if(COMMAND.valueOf(cmd[0].toUpperCase()) == COMMAND.CREATE_PARKING_LOT) {
			parkingLot = cmd.length == 2 ? new ParkingLot(Integer.valueOf(cmd[1])) : null;
		}
		
		//Parking Operation
		
		if (parkingLot != null) {
			ParkingLotServices services = new ParkingLotServices(parkingLot);
			while (sc.hasNextLine()) {
				try {
					line = sc.nextLine();
					cmd = line.split(" ");
					COMMAND C = COMMAND.valueOf(cmd[0].toUpperCase());
					switch (C) {
					case PARK:
						services.addVehicle(new VehicleParked(cmd[1], cmd[2], 0));
						break;
					case LEAVE:
						services.CarLeaving(Integer.valueOf(cmd[1]));
						break;
						
						 * case STATUS: services.status(); break; case
						 * REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR: { List<VehicleParked> list =
						 * services.searchColour(cmd[1]);
						 * 
						 * if (list != null && list.size() > 0) { list.forEach(l ->
						 * System.out.print(l.getRegNumber() + " ")); } else
						 * System.out.println("No car in Parking lot of this colour"); } break; case
						 * SLOT_NUMBERS_FOR_CARS_WITH_COLOUR: { List<VehicleParked> list =
						 * services.searchColour(cmd[1]); if (list != null && list.size() > 0) {
						 * list.forEach(l -> System.out.print(l.getParkingLocation() + " ")); } else {
						 * System.out.println("No car in Parking lot of this colour"); } } break;
						 
					case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
						services.searchRegNo(cmd[1]);
						break;
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Command please try again ");
				}
				catch (Exception e) {
					System.out.println("Following exception occured in code "+ e.getMessage());
				}
			}
		} else {
			System.out.println("Parking creation failes due to non integer size");
		}
		}
		catch (Exception ex) {
			System.out.println("Following Exception occured. Please try again " + ex.getMessage());
		}*/
	}

}
