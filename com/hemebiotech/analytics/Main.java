package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import javax.activation.FileTypeMap;


public class Main {
	
  	

  
	public static void main(String args[]) throws Exception {
		// first get input
		final String filepath = "symptoms.txt";


		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
    ISymptomWriter writer = new WriteSymptomDataToFile();

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		List<String> result = analyticsCounter.getSymptoms();
		Map<String, Integer> counter = analyticsCounter.countSymptoms(result);
		Map<String, Integer> sorter = analyticsCounter.sortSymptoms(counter);
		analyticsCounter.writeSymptoms(sorter);
		
	
	}
}