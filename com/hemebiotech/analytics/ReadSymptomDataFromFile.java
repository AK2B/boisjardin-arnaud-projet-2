package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
* Cette classe implémente l'interface ISymptomReader,
* permet de lire des données de symptômes à partir d'un fichier.
*/
public class ReadSymptomDataFromFile implements ISymptomReader {

  // Le chemin du fichier à lire
  private final String FILE_PATH;

  /**
   * Constructeur de la classe ReadSymptomDataFromFile.
   * @param FILE_PATH le chemin du fichier à lire
   */
  public ReadSymptomDataFromFile(String FILE_PATH) {
    this.FILE_PATH = FILE_PATH;
  }

  /**
   * Cette méthode lit les données à partir du fichier spécifié et retourne une liste de strings.
   * @return une liste de strings représentant les symptômes, ou null si une exception a été levée.
   */
  @Override
  public List<String> getSymptoms() {

    if (FILE_PATH != null) {
      File file = new File(FILE_PATH);
      if (file.exists()) {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
          return stream.collect(Collectors.toList());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}