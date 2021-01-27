package coms.ss.javabasics.week1.day5;

import static org.junit.jupiter.api.Assertions.fail;

import coms.ss.javabasics.KitUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ThreeLetterAWordTest {

  @Test
  public void runAllTest() {
    getThreeLetterWordsStartingWithLowercaseA();
  }

  // [TEST] getThreeLetterWordsStartingWithLowercaseA()
  @Test
  void getThreeLetterWordsStartingWithLowercaseA() {
    System.out.println(
      "\n[TEST] Lambdas.class - getThreeLetterWordsStartingWithLowercaseA()"
    );
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    String[][] testCases = {
      { "are", "aren't", "arm", "air" },
      { "aurora", "Arby's", "Air", "ate" }, // Uppercase
      { "ain't", "apple", "elbow", "penguin" }, // None/Empty
      { "airsoft", "avocado", "Ape", "ape" },
      { "art", "cart", "est", "pig" },
    };
    String[][] testResults = {
      { "are", "arm", "air" },
      { "ate" },
      { "" },
      { "ape" },
      { "art" },
    };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        List<String> words = Arrays.asList(testCases[i]);
        String actual = KitUtils.arrayToString(
          ThreeLetterAWord
            .getThreeLetterWordsStartingWithLowercaseA(words)
            .toArray(new String[0])
        );
        String expected = KitUtils.arrayToString(testResults[i]);
        String message = expected + " | " + actual;
        if (actual.equals(expected)) {
          System.out.println(i + ": " + message);
        } else {
          isPassing = false;
          System.err.println(i + ": " + message);
        }
      } catch (Exception e) {
        isPassing = false;
        System.err.println(i + ": " + e);
      }
    }

    // Assessment
    if (isPassing) {
      System.out.println("Passed");
    } else {
      System.err.println("Failed");
      fail();
    }
  }
}
