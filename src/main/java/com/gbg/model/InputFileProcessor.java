package com.gbg.model;

import com.gbg.exception.GBGException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.gbg.exception.ExceptionStatus.INVALID_CMD_ARGS;

/**
 * This class process input file
 * CSV files.
 *
 * @author Migara Kalubowilage
 * @version 1.0
 *
 */
public class InputFileProcessor {

  /**
   * Read file path from command line args
   *
   * @param args command line arguments
   *
   */
  public String getFilePath(String[] args) throws GBGException {
    // Validate commandline arguments
    if (args.length != 1) {
      throw new GBGException(INVALID_CMD_ARGS);
    }
    return args[0];
  }

  /**
   * Process input file
   *
   * @param filePath input file path
   *
   */
  public FileContent processInputFile(String filePath) {

    ArrayList<String> wordsList = new ArrayList<String>();
    String line;
    FileContent fileContent = null;
    int numberOfWords = 0, numberOfLines = 0;

    // try-with-resources statement takes care of closing the resource
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      while((line = br.readLine()) != null) {
        String[] string = line.toLowerCase().split("([,.\\s]+)");
        numberOfWords = numberOfWords + string.length;
        numberOfLines ++;
        Collections.addAll(wordsList, string);
      }

      fileContent = new FileContent();
      fileContent.setNumberOfWords(numberOfWords);
      fileContent.setNumberOfLines(numberOfLines);
      fileContent.setWordsList(wordsList);
      
    } catch (FileNotFoundException f) {
      System.out.println(filePath + " does not exist.");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return fileContent;
  }

  /**
   * Read the most frequent word in the file
   *
   * @param wordsList ArrayList<String> words list
   *
   */
  public String readMostFrequentWord(ArrayList<String> wordsList) {
    int count = 1, maxCount = 0;
    String word = "";

    for (int i = 0; i < wordsList.size(); i++) {
      // Count each word in the file and store it in variable count
      for (int j = i + 1; j < wordsList.size(); j++) {
        if (wordsList.get(i).equals(wordsList.get(j))) {
          count ++;
        }
      }

      // If maxCount is less than count then store value of count in maxCount
      // and corresponding word to variable word
      if (count > maxCount) {
        maxCount = count;
        word = wordsList.get(i);
      }
    }
    return word;
  }
}
