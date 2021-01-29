package coms.ss.javabasics.week1.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import coms.ss.javabasics.KitUtils;
import coms.ss.javabasics.TestUtils;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ThreeLetterAWordTest {

  @Test
  public void runAllTests() {
    getThreeLetterWordsStartingWithLowercaseA();
  }

  @Test
  void getThreeLetterWordsStartingWithLowercaseA() {
    Integer testCount = 1;
String testName =
      "week1.day5 - ThreeLetterAWordTest.class | getThreeLetterWordsStartingWithLowercaseA()";

    // Test Cases
    String[][] testCases = {
      { "are", "aren't", "arm", "air" },
      { "aurora", "Arby's", "Air", "ate" }, // Uppercase
      { "ain't", "apple", "elbow", "penguin" }, // None/Empty
      { "airsoft", "avocado", "Ape", "ape" },
      { "art", "cart", "est", "pig" },
    };

    // Test Results
    String[][] testResults = {
      { "are", "arm", "air" },
      { "ate" },
      { "" },
      { "ape" },
      { "art" },
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String actual = KitUtils.toString(
          ThreeLetterAWord.getThreeLetterWordsStartingWithLowercaseA(
            Arrays.asList(testCases[i])
          )
        );
        String expected = KitUtils.toString(testResults[i]);
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }
}
