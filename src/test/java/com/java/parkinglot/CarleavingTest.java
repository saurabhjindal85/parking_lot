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

public class CarleavingTest {

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
		processor.validateAndProcess("leave 2");//leave unavailable slot
		processor.validateAndProcess("leave 1");//leave 1
		processor.validateAndProcess("leave 1");//leave 1
		assertEquals("Parking lot Created with capacity of 1\r\n" + 
				"Vehicle KA-01-HH-1234 parked at 1\r\n" + 
				"Invalid Parking location\r\n" + 
				"Car parked at location 1 left\r\n" + 
				"No vehicle is parked at the given location\r\n"
		,outContent.toString());
	}

}
