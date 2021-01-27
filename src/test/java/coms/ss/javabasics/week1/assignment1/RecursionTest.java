package coms.ss.javabasics.week1.assignment1;

import static org.junit.jupiter.api.Assertions.fail;

import coms.ss.javabasics.week1.assingment5.Recursion;
import org.junit.jupiter.api.Test;

public class RecursionTest {

  @Test
  public void runAllTest() {
    canSumToValue();
    getClumpedValues();
    groupSumClump();
  }

  // [TEST] canSumToValue()
  @Test
  void canSumToValue() {
    System.out.println("\n[TEST] Recursion.class - canSumToValue()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    Integer[][] testCases = {
      { 2, 4, 8 },
      { 1, 2, 4, 8, 1 },
      { 10, 5, 5, 3 },
      { 42, 7, 9001, 12 },
      { 3, 4, 1, 7 },
      { 2, 3, 5, 7 },
    };

    Integer[] testParams = { 10, 14, 20, 4000, 9, 15 };
    Boolean[] testResults = { true, true, true, false, false, true };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        Boolean actual = Recursion.canSumToValue(
          testCases[i],
          testCases[i].length,
          testParams[i]
        );
        Boolean expected = testResults[i];
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

  // [TEST] getClumpedValues()
  @Test
  void getClumpedValues() {
    System.out.println("\n[TEST] Recursion.class - getClumpedValues()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    Integer[][] testCases = {
      { 2, 2, 2, 4, 8, 8, 9 },
      { 1, 2, 4, 8, 1 },
      { 10, 5, 5, 3 },
      { 42, 7, 9001, 12 },
      { 7, 7, 7, 7, 7, 7, 7 },
      { 2, 3, 3, 4, 5, 6, 7, 9, 9 },
      { 2, 3, 5, 7, 7 },
    };

    String[] testResults = { "2:3, 8:2", "", "5:2", "", "7:7", "3:2, 9:2", "7:2" };

    // Test

    for (int i = 0; i < testCases.length; i++) {
      StringBuilder sb = new StringBuilder();
      try {
        Integer[][] actualArray = Recursion.getClumpedValues(testCases[i]);
        for (int arrayIndex = 0; arrayIndex < actualArray.length; arrayIndex++) {
          sb.append(actualArray[arrayIndex][0] + ":" + actualArray[arrayIndex][1]);
          if (arrayIndex + 1 < actualArray.length) {
            sb.append(", ");
          }
        }
        String actual = sb.toString();
        String expected = testResults[i];
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

  // [TEST] groupSumClump()
  @Test
  void groupSumClump() {
    System.out.println("\n[TEST] Recursion.class - groupSumClump()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
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
    Boolean[] testResults = { true, true, false, true, false, true, false };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        Boolean actual = Recursion.groupSumClump(testCases[i], testParams[i]);
        Boolean expected = testResults[i];
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
