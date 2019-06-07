package com.java.parkinglot.process;

import java.util.Scanner;

public class CommandLineProcessor extends AbstractProcessor {

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);;
		
        while(sc.hasNextLine()) {
        	String command = sc.nextLine();
        	validateAndProcess(command);
        }
        sc.close();
	}

}
