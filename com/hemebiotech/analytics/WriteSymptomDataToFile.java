package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

// WRITE YOUR CODE HERE

public class WriteSymptomDataToFile implements ISymptomWriter {
	
    /**
	 * 
	 */
	public WriteSymptomDataToFile() {
	}
    
    public void writeSymptoms(Map<String,Integer> symptoms){
        final String outputFilePath = "result.out";
        // new file object
        File fichier = new File(outputFilePath);

        BufferedWriter bf = null;  

        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(fichier));

            // create new HashMap
            Map<String, Integer> map = symptoms;

            for (Entry<String, Integer> entry :
                map.entrySet()) {   
            // put key and value separated by a colon
                bf.write(entry.getKey() + " : "
                        + entry.getValue());
                // new line
                bf.newLine();   
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                bf.close();
            }
            catch (Exception e) {
                
            }
    }
    }
	
}
