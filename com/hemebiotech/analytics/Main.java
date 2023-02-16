package com.hemebiotech.analytics;

import java.util.Map;

public class Main {
	
	public static void main(String args[]) throws Exception {
		// first get input
		String filepath = "symptoms.txt";
		
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		
		Map<String, Integer> result = reader.getSymptoms();

		ISymptomWriter writer = new WriteSymptomDataToFile();
		writer.writeSymptoms(result);
	}
}