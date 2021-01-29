package coms.ss.javabasics.week1.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import coms.ss.javabasics.KitUtils;
import coms.ss.javabasics.TestUtils;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  public void runAllTests() {
    getSlope();
    getDistance();
    parallelTo();
  }

  @Test
  void getSlope() {
    Integer testCount = 1;
    String testName = "week1.day4 - Line.class | getSlope()";

    // Test Cases
    double[][] testCases = {
      { 1, 1, 2, 2 },
      { 1, 1, 2, 3 },
      { 7, 9, 14, 83 },
      { 8, 8, 0, 0 },
      { 8, 8, 8, 8 },
    };

    // Test Results
    double[] testResults = {
      1,
      2,
      10.5714,
      1,
      // throwException
    };

    // Test
    Runnable test = () -> {
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
          System.out.println(
            i +
            ": " +
            KitUtils.toString(expected) +
            " | " +
            KitUtils.toString(actual)
          );
          assertNotNull(actual);
          assertEquals(expected, actual, 0.0001);
        } catch (ArithmeticException e) {
          System.out.println(
            i + ": " + "Handled arithmetic exception (divide by 0) successfully"
          );
        }
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void getDistance() {
    Integer testCount = 1;
    String testName = "week1.day4 - Line.class | getDistance()";
    // Test Cases
    double[][] testCases = {
      { 1, 1, 2, 2 },
      { 1, 1, 2, 3 },
      { 7, 9, 14, 83 },
      { 8, 8, 0, 0 },
      { 8, 8, 8, 8 },
    };

    // Test Results
    double[] testResults = { 1.4142, 2.2360, 74.3303, 11.3137, 0 };

    // Test
    Runnable test = () -> {
      for (int i = 0; i < testCases.length; i++) {
        Line l = new Line(
          testCases[i][0],
          testCases[i][1],
          testCases[i][2],
          testCases[i][3]
        );

        double actual = l.getDistance();
        double expected = testResults[i];
        System.out.println(
          i +
          ": " +
          KitUtils.toString(expected) +
          " | " +
          KitUtils.toString(actual)
        );
        assertNotNull(actual);
        assertEquals(expected, actual, 0.0001);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void parallelTo() {
    Integer testCount = 1;
    String testName = "week1.day4 - Line.class | parallelTo()";

    // Test Cases
    Line testLine = new Line(1, 1, 2, 2);
    double[][] testCases = {
      { 1, 1, 2, 2 },
      { 1, 1, 2, 3 },
      { 7, 9, 14, 83 },
      { 8, 8, 0, 0 },
      { 8, 8, 8, 8 },
      { -1, -1, 2, 2 },
    };

    // Test Results
    boolean[] testResults = { true, false, false, true, false, true };

    // Test
    Runnable test = () -> {
      int iterations = testCases.length;
      for (int i = 0; i < iterations; i++) {
        Line l = new Line(
          testCases[i][0],
          testCases[i][1],
          testCases[i][2],
          testCases[i][3]
        );
        try {
          boolean actual = l.parallelTo(testLine);
          boolean expected = testResults[i];
          System.out.println(i + ": " + expected + " | " + actual);
          assertNotNull(actual);
          assertEquals(expected, actual);
        } catch (ArithmeticException e) {
          // prettier-ignore
          System.out.println(i +": " +
            "Handled ArithmeticException (non-directional line) successfully"
          );
        }
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }
}
