package com.gbg.model;

import com.gbg.exception.GBGException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInputFileProcessor {

  InputFileProcessor fileReader = new InputFileProcessor();

  @Test
  public void testGetFilePathSuccess() throws GBGException {
    String[] args = {"test1txt"};
    String filePath = fileReader.getFilePath(args);
    assertEquals("test1txt", filePath);
  }

  @Test(expected = GBGException.class)
  public void testGetFilePathError() throws GBGException {
    String[] args = {};
    fileReader.getFilePath(args);
  }

  @Test
  public void testProcessInputFileSuccess() throws GBGException {
    String[] args = {"src/test/resources/test1.txt"};

    String filePath = fileReader.getFilePath(args);
    assertEquals("src/test/resources/test1.txt", filePath);

    FileContent fileContent = fileReader.processInputFile(filePath);
    assertEquals(39, fileContent.getNumberOfWords());
    assertEquals(3, fileContent.getNumberOfLines());
    assertEquals(39, fileContent.getWordsList().size());
  }

  @Test
  public void testReadMostFrequentWordSuccess() throws GBGException {
    String[] args = {"src/test/resources/test2.txt"};

    String filePath = fileReader.getFilePath(args);
    assertEquals("src/test/resources/test2.txt", filePath);

    FileContent fileContent = fileReader.processInputFile(filePath);
    assertEquals(33, fileContent.getNumberOfWords());
    assertEquals(4, fileContent.getNumberOfLines());

    String mostFrequentWord = fileReader.readMostFrequentWord(fileContent.getWordsList());
    assertEquals("the", mostFrequentWord);
  }
}
