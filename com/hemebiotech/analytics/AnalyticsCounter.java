package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.stream.Collectors;


/**
 * La classe AnalyticsCounter fournit des fonctions pour compter les symptômes et les trier, 
 * puis les écrire à l'aide d'un objet ISymptomWriter.
 */
public class AnalyticsCounter {

  /**
  * Initialise un nouvel objet AnalyticsCounter,
  * avec un objet ISymptomReader et un objet ISymptomWriter en entrée, 
  * puis on utilise ces objets pour lire, compter, trier et écrire les symptômes.
  * 
  * @param reader L'objet ISymptomReader qui lit les symptômes
  * @param writer L'objet ISymptomWriter qui écrit les symptômes triés
  */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

    List<String> symptoms = reader.getSymptoms();
    System.out.println("Etape 1 : reader " + symptoms);

    Map<String, Integer> counter = this.countSymptoms(symptoms);
    System.out.println("Etape 2 : counter " + counter);
    Map<String, Integer> sorter = this.sortSymptoms(counter);
    System.out.println("Etape 3 : sorter " + sorter);

    Map<String, Integer> countAndSort = this.countAndSortSymptoms(symptoms);
    System.out.println("Etape Bis : count and sort " + countAndSort);

    writer.writeSymptoms(countAndSort);
    System.out.println("Etape 4 : writer ok");
  }

  /**
  * Compte les occurrences de chaque symptôme dans la liste des symptômes en entrée.
  * 
  * @param symptoms La liste des symptômes à compter
  * @return Une carte de comptage avec chaque symptôme et le nombre d'occurrences de ce symptôme
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) { 

    Map<String, Integer> countedSymptoms = new HashMap<>();
    for (String s: symptoms) {
      Integer counter = countedSymptoms.get(s);
      if (counter == null) {
        counter = 0;
      }
      countedSymptoms.put(s, counter + 1);
    } 

    return countedSymptoms;
  }

  /**
  * Trie les symptômes en utilisant une carte de comptage des symptômes.
  * 
  * @param counter La carte de comptage des symptômes à trier
  * @return Map triée des symptômes avec chaque symptôme et son nombre d'occurrences
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> counter) {

    Map<String, Integer> sortedSymptoms = counter.entrySet()
        .stream()
        .sorted(Map.Entry.<String, Integer>comparingByKey())
        .collect(Collectors.toMap(
          Map.Entry::getKey, 
          Map.Entry::getValue, 
          (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    return sortedSymptoms;
  }

  /**
  * Compte le nombre d'occurrences de chaque symptôme dans la liste de symptômes fournie
  * et trie les symptômes par ordre alphabétique.
  * @param symptoms La liste de symptômes à compter et trier
  * @return Une carte triée des symptômes avec chaque symptôme et son nombre d'occurrences
  */
  public Map<String, Integer> countAndSortSymptoms(List<String> symptoms) {
    // Crée une nouvelle carte de comptage des symptômes
    Map<String, Integer> countedSymptoms = new HashMap<>();
    // Pour chaque symptôme dans la liste, incrémente le compteur correspondant dans la carte
    for (String symptom : symptoms) {
      countedSymptoms.merge(symptom, 1, Integer::sum);
    }
    // Trie la carte par ordre alphabétique des clés et retourne une vue triée
    return new TreeMap<>(countedSymptoms);
  }

}