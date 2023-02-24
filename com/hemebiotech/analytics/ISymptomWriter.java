package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
* This functional interface represents a writer for symptom data.
*/
@FunctionalInterface
public interface ISymptomWriter {
  /**
  * Writes the symptom data to the output.
  * @param sorter a Map that contains the sorted symptom data to be written.
  */
  public void writeSymptoms(Map<String, Integer> sorter);
}