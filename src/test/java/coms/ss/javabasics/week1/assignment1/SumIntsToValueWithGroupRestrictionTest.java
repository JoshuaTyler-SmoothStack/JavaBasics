package coms.ss.javabasics.week1.assignment1;

import static org.junit.jupiter.api.Assertions.fail;

import coms.ss.javabasics.KitUtils;
import coms.ss.javabasics.week1.assingment5.SumIntsToValueWithGroupRestriction;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class SumIntsToValueWithGroupRestrictionTest {

  @Test
  public void runAllTest() {
    calculateHashMapRowSums();
    canSumToValue();
  }

  // [TEST] calculateHashMapRowSums()
  @Test
  void calculateHashMapRowSums() {
    System.out.println("\n[TEST] Lambdas.class - calculateHashMapRowSums()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    HashMap<String, Integer> testCase1 = new HashMap<String, Integer>();
    testCase1.put("1,2", 3);
    testCase1.put("1,4", 5);
    testCase1.put("1,8", 9);
    testCase1.put("1,1", 2);
    testCase1.put("2,1", 3);
    testCase1.put("2,4", 6);
    testCase1.put("2,8", 10);
    testCase1.put("4,1", 5);
    testCase1.put("4,2", 6);
    testCase1.put("4,8", 12);
    testCase1.put("8,1", 9);
    testCase1.put("8,2", 10);
    testCase1.put("8,4", 12);
    testCase1.put("1d,2", 3);
    testCase1.put("1d,4", 5);
    testCase1.put("1d,8", 9);

    Integer[] testParams = { 1, 2, 4, 8 };
    Integer[][] testResults = {
      { 7, 11, 4, 13, 6, 10 },
      { 7, 11, 4, 14 },
      { 7, 13, 6, 14 },
      { 11, 13, 14, 10 },
    };

    // Test
    for (int i = 0; i < testParams.length; i++) {
      try {
        Integer[] actualAsArray = SumIntsToValueWithGroupRestriction
          .calculateHashMapRowSums(testCase1, testParams[i])
          .toArray(new Integer[0]);
        Arrays.sort(actualAsArray);
        String actual = KitUtils.arrayToString(actualAsArray);
        Arrays.sort(testResults[i]);
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

  // [TEST] canSumToValue()
  @Test
  void canSumToValue() {
    System.out.println("\n[TEST] Lambdas.class - canSumToValue()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    Integer[][] testCases = {
      { 2, 4, 8 },
      { 1, 2, 4, 8, 1 },
      { 10, 5, 5, 3 },
      { 42, 7, 9, 12 },
      { 3, 4, 1, 7 },
    };

    Integer[] testParams = { 10, 14, 20, 4000, 9 };
    Boolean[] testResults = { true, true, true, false, false };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        Boolean actual = SumIntsToValueWithGroupRestriction.canSumToValue(testCases[i], testParams[i]);
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
