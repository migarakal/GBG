package com.gbg;

import com.gbg.exception.GBGException;
import com.gbg.model.FileContent;
import com.gbg.model.InputFileProcessor;

import java.util.Objects;

/**
 * Use PaperCut class to run console application.
 *
 * @author Migara Kalubowilage
 * @version 1.0
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    InputFileProcessor fileReader = new InputFileProcessor();

    try {
      // Get input file path
      String filePath = fileReader.getFilePath(args);

      // Read input file
      FileContent fileContent = fileReader.processInputFile(filePath);

      // Print details
      if (fileContent != null) {
        System.out.println("Number of words = " + fileContent.getNumberOfWords());
        System.out.println("Number of lines = " + fileContent.getNumberOfLines());

        String mostFrequentWord = fileReader.readMostFrequentWord(fileContent.getWordsList());
        if (!Objects.equals(mostFrequentWord, "")) {
          System.out.println("Most repeated word = " + mostFrequentWord);
        }
      }
    } catch (GBGException e) {
      System.out.println(e.getMessage());
    }
  }
}