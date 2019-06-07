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
import com.java.parkinglot.services.ParkingLotServices;

public class ParkingAppTest {

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
	public void testParkCar_availableSpace() throws Exception {
		ParkingLot.resetTheInstance();
		//processor.getParkingLotServices().resetTheInstance();//destroying Parking object for test
		processor.validateAndProcess("create_parking_lot 1");// create parking
		processor.validateAndProcess("create_parking_lot 1");// singleton
		processor.validateAndProcess("park KA-01-HH-1234 White");// park car
		processor.validateAndProcess("park KA-01-HH-1 White");// parking full
		parked = new VehicleParked("KA-01-HH-1234", "White", 1);
		assertEquals("Parking lot Created with capacity of 1\r\n" + 
				"Parking Lot is already existing with the capacity of : 1\r\n" + 
				"Vehicle KA-01-HH-1234 parked at 1\r\n" + 
				"Parking space is full\r\n", outContent.toString());
	}
}
