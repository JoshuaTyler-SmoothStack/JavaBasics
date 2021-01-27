package coms.ss.javabasics.week1.day5;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class EvenOddCSVsTest {

  @Test
  public void runAllTest() {
    intsToEvenOddCSVs();
  }

  // [TEST] intsToEvenOddCSVs()
  @Test
  void intsToEvenOddCSVs() {
    System.out.println("\n[TEST] Lambdas.class - intsToEvenOddCSVs()");
    System.out.println("==================================");
    System.out.println("#Test | Expected | Actual");

    // Setup
    boolean isPassing = true;
    int[][] testCases = {
      { 1, 2, 3, 4 }, // Standard
      { 30, 42, 0, 7 }, // Zero
      { -1, -42, 93, 6 }, // Negative
      { 40001, 8, 11, 64 },
      { 59, 12, 290, 25 },
    };
    String[] testResults = {
      "o1,e2,o3,e4",
      "e30,e42,e0,o7",
      "o-1,e-42,o93,e6",
      "o40001,e8,o11,e64",
      "o59,e12,e290,o25",
    };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      try {
        String actual = EvenOddCSVs.intsToEvenOddCSVs(testCases[i]);
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
}