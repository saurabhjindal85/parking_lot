package com.java.parkinglot;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java.parkinglot.model.ParkingLot;
import com.java.parkinglot.model.VehicleParked;
import com.java.parkinglot.process.AbstractProcessor;
import com.java.parkinglot.process.CommandLineProcessor;

public class CarSearchTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	AbstractProcessor processor = null;
	VehicleParked parked;

	@Before
	public void property() throws Exception {
		processor = new CommandLineProcessor();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));

	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}


	@Test
	public void testParkCar_CarSearchWithColor() throws Exception {
		ParkingLot.resetTheInstance();
		processor.validateAndProcess("create_parking_lot 1");//create parking
		processor.validateAndProcess("park KA-01-HH-1234 White");//park car
		processor.validateAndProcess("registration_numbers_for_cars_with_colour White");//search
		processor.validateAndProcess("registration_numbers_for_cars_with_colour Blue");//fail search
		processor.validateAndProcess("slot_number_for_registration_number KA-01-HH-1234");//search reg no
		assertEquals("Parking lot Created with capacity of 1\r\n"+
		"Vehicle KA-01-HH-1234 parked at 1\r\n" + 
		"KA-01-HH-1234 \r\n"+
		"No car in Parking lot of this colour\r\n" + 
		"Vehicle not parked in this Parking\r\n"
		,outContent.toString());
	}
	
}
