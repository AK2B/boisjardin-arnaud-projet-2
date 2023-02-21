package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.IOException;

import java.util.stream.Collectors;


public class AnalyticsCounter { 

	private static final String filepath = "symptoms.txt";

	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
   }
		
  public List<String> getSymptoms() { 
			ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
			List<String> symptoms = reader.getSymptoms();	
			System.out.println("Etape 1 : reader " + symptoms);
			return symptoms;
   }

    
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		
     Map<String, Integer> countedSymptoms = new HashMap<>();
        for (String s: symptoms)
        {
            Integer count = countedSymptoms.get(s);
            if (count == null) {
                count = 0;
            }
            countedSymptoms.put(s, count + 1);
        } 
        	System.out.println("Etape 2 : counter " + countedSymptoms);
        	return countedSymptoms;	
		}

	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> counter) {
			      
		Map<String, Integer> sortedSymptoms = counter.entrySet()
		    	.stream()
		    	.sorted(Map.Entry.<String, Integer>comparingByKey())
		    	
		    	//HashMap doesn't guarantee iteration order, while LinkedHashMap does.
		    	.collect(Collectors.toMap(
		    			Map.Entry::getKey, 
		    			Map.Entry::getValue, 
		    			(oldValue, newValue) -> oldValue, LinkedHashMap::new));	
		System.out.println("Etape 3 : sorter "+sortedSymptoms);
		return sortedSymptoms;
		}


		public void writeSymptoms(Map<String, Integer> sorter) {
		
		    
		      ISymptomWriter writer = new WriteSymptomDataToFile();
		      writer.writeSymptoms(sorter);
		 
	    
      		 
  }
}




/*
public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String args[]) throws Exception {    
    //  first get input
		BufferedReader reader = new BufferedReader (new FileReader("Symptoms.txt"));
		String line = reader.readLine();

		int i = 0; 
		int headCount = 0;	//  counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
    reader.close();    
	}
}

*/
