package coms.ss.javabasics.week1.day5;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import coms.ss.javabasics.KitUtils;

public class LambdasTest {

  @Test
  public void runAllTests() {
    sortAlphabetically();
    sortLengthSmallest();
    sortLengthLargest();
  }

  // [TEST] sortAlphabetically()
  @Test
  void sortAlphabetically() {
    System.out.println("\n[TEST] Lambdas.class - sortAlphabetically()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };
    String[][] testResults = {
      { "a", "seventy", "what", "yo-yo" },
      { "3", "ipsum", "lorem", "two" },
      { "hello", "penguin", "when", "world" },
      { "case", "overload", "running", "test" },
      { "guinea", "jambon", "pig", "system" },
    };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        String actual = KitUtils.arrayToString(
          Lambdas.sortAlphabetically(testCases[i])
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

  // [TEST] sortLengthSmallest()
  @Test
  void sortLengthSmallest() {
    System.out.println("\n[TEST] Lambdas.class - sortLengthSmallest()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };
    String[][] testResults = {
      { "a", "what", "yo-yo", "seventy" },
      { "3", "two", "lorem", "ipsum" },
      { "when", "hello", "world", "penguin" },
      { "test", "case", "running", "overload" },
      { "pig", "system", "jambon", "guinea" },
    };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        String actual = KitUtils.arrayToString(
          Lambdas.sortLengthSmallest(testCases[i])
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

  // [TEST] sortLengthLargest()
  @Test
  void sortLengthLargest() {
    System.out.println("\n[TEST] Lambdas.class - sortLengthLargest()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };
    String[][] testResults = {
      { "seventy", "yo-yo", "what", "a" },
      { "lorem", "ipsum", "two", "3" },
      { "penguin", "hello", "world", "when" },
      { "overload", "running", "test", "case" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        String actual = KitUtils.arrayToString(
          Lambdas.sortLengthLargest(testCases[i])
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

  // [TEST] sortWithE()
  @Test
  void sortWithE() {
    System.out.println("\n[TEST] Lambdas.class - sortWithE()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };
    String[][] testResults = {
      { "seventy", "a", "yo-yo", "what" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "when", "penguin", "world" },
      { "test", "case", "overload", "running" },
      { "system", "guinea", "jambon", "pig" },
    };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        String actual = KitUtils.arrayToString(
          Lambdas.sortWithE(testCases[i])
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

    // [TEST] sortWithEUtils()
    @Test
    void sortWithEUtils() {
      System.out.println("\n[TEST] Lambdas.class - sortWithEUtils()");
      System.out.println("==================================");
      System.out.println("#Test | Expected | Actual");
  
      // Setup
      boolean isPassing = true;
      String[][] testCases = {
        { "a", "yo-yo", "what", "seventy" },
        { "lorem", "ipsum", "two", "3" },
        { "hello", "world", "when", "penguin" },
        { "test", "case", "running", "overload" },
        { "system", "jambon", "guinea", "pig" },
      };
      String[][] testResults = {
        { "seventy", "a", "yo-yo", "what" },
        { "lorem", "ipsum", "two", "3" },
        { "hello", "when", "penguin", "world" },
        { "test", "case", "overload", "running" },
        { "system", "guinea", "jambon", "pig" },
      };
  
      // Test
      for (int i = 0; i < testCases.length; i++) {
        try {
          String actual = KitUtils.arrayToString(
            Lambdas.sortWithEUtils(testCases[i])
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