package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public Map<String, Integer> getSymptoms() {	
		
        try(Scanner scan = new Scanner(new FileReader(filepath))) { 
        		
					Map<String, Integer> occurence = new HashMap<>();
        		
					while (scan.hasNextLine()) {
        			String line = scan.nextLine();
        			occurence.putIfAbsent(line, 0);
        			occurence.put(line, occurence.get(line) + 1);	
        	}		        	
        		//Ordre alphabétique 
        		// trier par clé, comparateur  compareByKey
				 
			  	Map<String, Integer> result = occurence.entrySet()
			    		.stream()
              
			    		.sorted(Map.Entry.<String, Integer>comparingByKey())
			    	
			    	//HashMap doesn't guarantee iteration order, while LinkedHashMap does.
			    		.collect(Collectors.toMap(
			    				Map.Entry::getKey, 
			    				Map.Entry::getValue, 
			    				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
							
							
			    		System.out.println(result);
			    		
							return result;	
        }		        
		    				    
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		
		return null ;

		}
	}
