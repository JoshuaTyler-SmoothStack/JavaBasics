package coms.ss.javabasics.week1.day4;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  public void runAllTests() {
    getSlope();
    getDistance();
    parallelTo();
  }

  //region [TEST] getSlope()
  @Test
  void getSlope() {
    System.out.println("\n[TEST] Line.class - getSlope()");
    System.out.println("==================================");

    // Setup
    boolean isPassing = true;
    double[][] testCases = {
      { 1, 1, 2, 2 },
      { 1, 1, 2, 3 },
      { 7, 9, 14, 83 },
      { 8, 8, 0, 0 },
      { 8, 8, 8, 8 },
    };
    double[] testResults = {
      1,
      2,
      10.5714,
      1,
      // throwException
    };

    for (int i = 0; i < testCases.length; i++) {
      Line l = new Line(
        testCases[i][0],
        testCases[i][1],
        testCases[i][2],
        testCases[i][3]
      );
      try {
        double actual = l.getSlope();
        double expected = testResults[i];
        String message = "expected: " + expected + " | result: " + actual;
        if (Math.abs(actual - expected) < 0.0001) {
          System.out.println(i + ": " + message);
        } else {
          isPassing = false;
          System.err.println(i + ": " + message);
        }
      } catch (ArithmeticException e) {
        System.out.println(i + ": " + "Handled Exception");
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
    System.out.println("==================================");
  }

  //endregion

  //region [TEST] getDistance()
  @Test
  void getDistance() {
    System.out.println("\n[TEST] Line.class - getDistance()");
    System.out.println("==================================");

    // Setup
    boolean isPassing = true;
    double[][] testCases = {
      { 1, 1, 2, 2 },
      { 1, 1, 2, 3 },
      { 7, 9, 14, 83 },
      { 8, 8, 0, 0 },
      { 8, 8, 8, 8 },
    };
    double[] testResults = { 1.4142, 2.2360, 74.3303, 11.3137, 0 };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      Line l = new Line(
        testCases[i][0],
        testCases[i][1],
        testCases[i][2],
        testCases[i][3]
      );

      try {
        double actual = l.getDistance();
        double expected = testResults[i];
        String message = "expected: " + expected + " | result: " + actual;
        if (Math.abs(actual - expected) < 0.0001) {
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
    System.out.println("==================================");
  }

  //endregion

  //region [TEST] parallelTo()
  @Test
  void parallelTo() {
    System.out.println("\n[TEST] Line.class - parellelTo()");
    System.out.println("==================================");

    // Setup
    boolean isPassing = true;
    Line l1 = new Line(1, 1, 2, 2);
    double[][] testCases = {
      { 1, 1, 2, 2 },
      { 1, 1, 2, 3 },
      { 7, 9, 14, 83 },
      { 8, 8, 0, 0 },
      { 8, 8, 8, 8 },
      { -1, -1, 2, 2 },
    };
    boolean[] testResults = { true, false, false, true, false, true };

    // Test
    for (int i = 0; i < testCases.length; i++) {
      Line l2 = new Line(
        testCases[i][0],
        testCases[i][1],
        testCases[i][2],
        testCases[i][3]
      );
      try {
        boolean actual = l1.parallelTo(l2);
        boolean expected = testResults[i];
        String message = "expected: " + expected + " | result: " + actual;
        if (actual == expected) {
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
    System.out.println("==================================");
  }
  //endregion
}