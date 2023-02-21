package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String args[]) throws Exception {
		// first get input
		
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(null, null);
		List<String> result = analyticsCounter.getSymptoms();
		Map<String, Integer> counter = analyticsCounter.countSymptoms(result);
		Map<String, Integer> sorter = analyticsCounter.sortSymptoms(counter);
		analyticsCounter.writeSymptoms(sorter);
		
	
	}
}