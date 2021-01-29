package coms.ss.javabasics.week1.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import coms.ss.javabasics.KitUtils;
import coms.ss.javabasics.TestUtils;
import org.junit.jupiter.api.Test;

public class LambdasTest {

  @Test
  public void runAllTests() {
    sortAlphabetically();
    sortLengthSmallest();
    sortLengthLargest();
  }

  @Test
  void sortAlphabetically() {
    Integer testCount = 1;
String testName = "week1.day5 - Lambdas.class | sortAlphabetically()";

    // Test Cases
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test Results
    String[][] testResults = {
      { "a", "seventy", "what", "yo-yo" },
      { "3", "ipsum", "lorem", "two" },
      { "hello", "penguin", "when", "world" },
      { "case", "overload", "running", "test" },
      { "guinea", "jambon", "pig", "system" },
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String expected = KitUtils.toString(testResults[i]);
        String actual = KitUtils.toString(
          Lambdas.sortAlphabetically(testCases[i])
        );
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void sortLengthSmallest() {
    Integer testCount = 1;
String testName = "week1.day5 - Lambdas.class | sortLengthSmallest()";

    // Test Cases
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test Results
    String[][] testResults = {
      { "a", "what", "yo-yo", "seventy" },
      { "3", "two", "lorem", "ipsum" },
      { "when", "hello", "world", "penguin" },
      { "test", "case", "running", "overload" },
      { "pig", "system", "jambon", "guinea" },
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String expected = KitUtils.toString(testResults[i]);
        String actual = KitUtils.toString(
          Lambdas.sortLengthSmallest(testCases[i])
        );
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void sortLengthLargest() {
    Integer testCount = 1;
String testName = "week1.day5 - Lambdas.class | sortLengthLargest()";

    // Test Cases
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test Results
    String[][] testResults = {
      { "seventy", "yo-yo", "what", "a" },
      { "lorem", "ipsum", "two", "3" },
      { "penguin", "hello", "world", "when" },
      { "overload", "running", "test", "case" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String expected = KitUtils.toString(testResults[i]);
        String actual = KitUtils.toString(
          Lambdas.sortLengthLargest(testCases[i])
        );
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void sortWithE() {
    Integer testCount = 1;
String testName = "week1.day5 - Lambdas.class | sortWithE()";

    // Test Cases
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test Results
    String[][] testResults = {
      { "seventy", "a", "yo-yo", "what" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "when", "penguin", "world" },
      { "test", "case", "overload", "running" },
      { "system", "guinea", "jambon", "pig" },
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String expected = KitUtils.toString(testResults[i]);
        String actual = KitUtils.toString(Lambdas.sortWithE(testCases[i]));
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void sortWithEUtils() {
    Integer testCount = 1;
String testName = "week1.day5 - Lambdas.class | sortWithEUtils()";

    // Test Cases
    String[][] testCases = {
      { "a", "yo-yo", "what", "seventy" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "world", "when", "penguin" },
      { "test", "case", "running", "overload" },
      { "system", "jambon", "guinea", "pig" },
    };

    // Test Results
    String[][] testResults = {
      { "seventy", "a", "yo-yo", "what" },
      { "lorem", "ipsum", "two", "3" },
      { "hello", "when", "penguin", "world" },
      { "test", "case", "overload", "running" },
      { "system", "guinea", "jambon", "pig" },
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String expected = KitUtils.toString(testResults[i]);
        String actual = KitUtils.toString(Lambdas.sortWithEUtils(testCases[i]));
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }
}
