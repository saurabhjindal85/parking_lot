package com.java.parkinglot.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileProcessor extends AbstractProcessor {

	String filePath = null;

	public FileProcessor(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void process() throws Exception {
		BufferedReader br = null;
		try {
			File inputFile = new File(filePath);
			br = new BufferedReader(new FileReader(inputFile));
			String line;
			while ((line = br.readLine()) != null) {
				validateAndProcess(line);
			} 
		} finally {
			br.close();
		}
		
	}

}
