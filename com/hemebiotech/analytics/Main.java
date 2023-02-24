package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
*
* Compte les occurrences de chaque symptôme en utilisant les données contenues dans un fichier.
*
* @author  Boisjardin Arnaud
* @version 1.0 
* @since   2023-02-21
*
**/

/**
* La classe principale qui lance l'application.
*/
public class Main {

  /**
  *  Chemin du fichier contenant les symptômes
  */
  public static final String FILE_PATH = "symptoms.txt";

  /**
  * Méthode principale qui crée les objets nécessaires et lance l'application.
  * @param args arguments de la ligne de commande (non utilisés)
  * @throws Exception si une erreur se produit lors de la lecture ou de l'écriture des données
  */
  public static void main(String [] args) throws Exception {
    // Création d'un objet ReadSymptomDataFromFile qui lit les données à partir du fichier
    ISymptomReader reader = new ReadSymptomDataFromFile(FILE_PATH);
    
    // Création d'un objet WriteSymptomDataToFile qui écrit les données triées dans un fichier
    ISymptomWriter writer = new WriteSymptomDataToFile();
    
    // Création d'un objet AnalyticsCounter qui calcule et écrit les données triées dans un fichier
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
    
    // Vérification que l'objet AnalyticsCounter a été créé avec succès
    if (analyticsCounter == null) {
      throw new Exception("Erreur lors de la création de l'objet AnalyticsCounter.");
    }
  }
}
