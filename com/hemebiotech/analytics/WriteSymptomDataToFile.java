package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;


/**
 * Implémente l'interface ISymptomWriter,
 * pour écrire les données de symptômes triées dans un fichier de sortie.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

  /**
   * Constructeur de la classe.
   */
  public WriteSymptomDataToFile() { }

  /**
   * Écrit les données triées dans un fichier de sortie.
   * @param sorter une map triée des symptômes avec leur compteur d'occurrences
   */
  @Override
  public void writeSymptoms(Map<String, Integer> sorter) {
    // Définition du chemin d'accès au fichier de sortie
    final String outputFilePath = "result.out";
    File fichier = new File(outputFilePath);

    try (BufferedWriter bf = new BufferedWriter(new FileWriter(fichier))) {
      // Parcours de la map et écriture de chaque entrée dans le fichier de sortie
      for (Entry<String, Integer> entry : sorter.entrySet()) {
        bf.write(entry.getKey() + " : " + entry.getValue());
        bf.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}