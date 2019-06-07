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
			e.printStackTrace();
		}

	}

}
