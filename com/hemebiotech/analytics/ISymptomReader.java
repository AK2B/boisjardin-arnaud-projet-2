package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.util.List;


/**
* L'interface fonctionnelle ISymptomReader.
*/
@FunctionalInterface
public interface ISymptomReader {

  /**
  * Returns liste de symptomes.
  * @return a list of strings representing symptoms
  */
  public List<String> getSymptoms();
}