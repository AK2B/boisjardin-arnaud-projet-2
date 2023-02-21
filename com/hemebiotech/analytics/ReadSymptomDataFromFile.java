package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
  /**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
    
		this.filepath = filepath;
	}
	

	@Override
	public List<String> getSymptoms() {
		
		if (filepath != null) {
			
			try {
				List<String> symptoms = Files.readAllLines(Paths.get(filepath));
				return symptoms;
			} catch (IOException e) {
				e.printStackTrace();
				}
			}
		return null;	
	  }
}