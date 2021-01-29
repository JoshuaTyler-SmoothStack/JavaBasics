package coms.ss.javabasics.week1.assignment5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import coms.ss.javabasics.KitUtils;
import coms.ss.javabasics.TestUtils;
import coms.ss.javabasics.week1.assingment5.Recursion;
import org.junit.jupiter.api.Test;

public class RecursionTest {

  @Test
  public void runAllTests() {
    canSumToValue();
    getClumpedValues();
    getDeClumpedValues();
    groupSumClump();
    hasAdjacentIdenticals();
  }

  @Test
  void canSumToValue() {
    Integer testCount = 1;
    String testName = "week1.assignment5 - Recursion.class | canSumToValue()";

    // Test Cases
    Integer[][] testCases = {
      { 2, 4, 8 },
      { 1, 2, 4, 8, 1 },
      { 10, 5, 5, 3 },
      { 42, 7, 9001, 12 },
      { 3, 4, 1, 7 },
      { 2, 3, 5, 7 },
    };
    Integer[] testParams = { 10, 14, 20, 4000, 9, 15 };

    // Test Results
    Boolean[] testResults = { true, true, true, false, false, true };

    // Test
    Runnable test = () -> {
      for (int i = 0; i < testCases.length; i++) {
        Boolean expected = testResults[i];
        Boolean actual = Recursion.canSumToValue(
          testCases[i],
          testCases[i].length,
          testParams[i]
        );
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void getClumpedValues() {
    Integer testCount = 1;
    String testName =
      "week1.assignment5 - Recursion.class | getClumpedValues()";

    // Test Cases
    Integer[][] testCases = {
      { 2, 2, 2, 4, 8, 8, 9 },
      { 1, 2, 4, 8, 1 },
      { 10, 5, 5, 3 },
      { 42, 7, 9001, 12 },
      { 7, 7, 7, 7, 7, 7, 7 },
      { 2, 3, 3, 4, 5, 6, 7, 9, 9 },
      { 2, 3, 5, 7, 7 },
    };

    // Test Results
    String[] testResults = {
      "2:3, 8:2",
      "",
      "5:2",
      "",
      "7:7",
      "3:2, 9:2",
      "7:2",
    };

    // Test
    Runnable test = () -> {
      for (int i = 0; i < testCases.length; i++) {
        String actual = KitUtils.toString(
          Recursion.getClumpedValues(testCases[i])
        );
        String expected = testResults[i];
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void getDeClumpedValues() {
    Integer testCount = 1;
    String testName =
      "week1.assignment5 - Recursion.class | getDeClumpedValues()";

    // Test Cases
    Integer[][] testCases = {
      { 2, 2, 2, 4, 8, 8, 9 },
      { 1, 2, 4, 8, 1 },
      { 10, 5, 5, 3 },
      { 42, 7, 9001, 12 },
      { 7, 7, 7, 7, 7, 7, 7 },
      { 2, 3, 3, 4, 5, 6, 7, 9, 9 },
      { 2, 3, 5, 7, 7 },
    };

    // Test Results
    Integer[][] testResults = {
      { 6, 4, 16, 9 },
      { 1, 2, 4, 8, 1 },
      { 10, 10, 3 },
      { 42, 7, 9001, 12 },
      { 49 },
      { 2, 6, 4, 5, 6, 7, 18 },
      { 2, 3, 5, 14 },
    };

    // Test
    Runnable test = () -> {
      for (int i = 0; i < testCases.length; i++) {
        String actual = KitUtils.toString(
          Recursion.getDeClumpedValues(testCases[i])
        );
        String expected = KitUtils.toString(testResults[i]);
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void groupSumClump() {
    Integer testCount = 1;
    String testName = "week1.assignment5 - Recursion.class | getSumClump()";

    // Test Cases
    Integer[][] testCases = {
      { 1, 2, 4, 8, 1 },
      { 2, 2, 4, 8, 2 },
      { 10, 5, 5, 5, 3 },
      { 5, 5, 5, 12 },
      { 3, 4, 1, 7 },
      { 2, 3, 5, 7 },
      { 2, 3, 5, 7, 7 },
    };
    Integer[] testParams = { 10, 10, 20, 15, 9, 15, 15 };

    // Test Results
    Boolean[] testResults = { true, true, false, true, false, true, false };

    // Test
    Runnable test = () -> {
      for (int i = 0; i < testCases.length; i++) {
        Boolean actual = Recursion.groupSumClump(testCases[i], testParams[i]);
        Boolean expected = testResults[i];
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void hasAdjacentIdenticals() {
    Integer testCount = 1;
    String testName =
      "week1.assignment5 - Recursion.class | hasAdjacentIdenticals()";

    // Test Cases
    Integer[][] testCases = {
      { 1, 2, 4, 8, 1 },
      { 2, 2, 4, 8, 2 },
      { 10, 5, 5, 5, 3 },
      { 5, 5, 5, 12 },
      { 3, 4, 1, 7 },
      { 2, 3, 5, 7 },
      { 2, 3, 3, 5, 7, 7 },
    };
    Integer[] testParams = { 1, 1, 1, 1, 1, 1, 1 };

    // Test Results
    Boolean[] testResults = { false, true, true, true, false, false, true };

    // Test
    Runnable test = () -> {
      for (int i = 0; i < testCases.length; i++) {
        Boolean actual = Recursion.hasAdjacentIdenticals(
          testCases[i],
          testParams[i]
        );
        Boolean expected = testResults[i];
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }
}
