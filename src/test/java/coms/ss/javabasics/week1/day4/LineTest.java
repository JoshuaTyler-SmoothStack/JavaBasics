package coms.ss.javabasics.week1.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LineTest {

  // Get Slope
  private static final double[][] testCases = {
    { 1, 1, 2, 2 },
    { 1, 1, 2, 3 },
    { 7, 9, 14, 83 },
    { 8, 8, 0, 0 },
  };

  private static final double[] testResults = {
    1,
    2,
    10.571428571429,
    9.8994949366117,
  };

  @Test
  void getSlope() {
    for (int i = 0; i < testCases.length; i++) {
      Line l = new Line(
        testCases[i][0],
        testCases[i][1],
        testCases[i][2],
        testCases[i][3]
      );
      double actual = l.getSlope();
      double expected = testResults[i];
      String message = "expected: " + expected + "\nresult: " + actual;
      assertEquals(expected, actual, 0.0001, message);
    }
  }
}
