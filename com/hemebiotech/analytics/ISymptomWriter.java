package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;
/**
 * Anything the will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {

  /**
 * @return 
  */
public void writeSymptoms(Map<String, Integer> sorter) ;
}
