package com.gbg.model;

import java.util.ArrayList;

public class FileContent {

  private int numberOfWords;
  private int numberOfLines;
  private ArrayList<String> wordsList;

  public int getNumberOfWords() {
    return numberOfWords;
  }

  public void setNumberOfWords(int numberOfWords) {
    this.numberOfWords = numberOfWords;
  }

  public int getNumberOfLines() {
    return numberOfLines;
  }

  public void setNumberOfLines(int numberOfLines) {
    this.numberOfLines = numberOfLines;
  }

  public ArrayList<String> getWordsList() {
    return wordsList;
  }

  public void setWordsList(ArrayList<String> wordsList) {
    this.wordsList = wordsList;
  }
}