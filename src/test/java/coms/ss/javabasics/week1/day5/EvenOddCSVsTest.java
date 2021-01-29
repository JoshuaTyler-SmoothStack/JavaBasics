package coms.ss.javabasics.week1.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import coms.ss.javabasics.TestUtils;
import org.junit.jupiter.api.Test;

public class EvenOddCSVsTest {

  @Test
  public void runAllTests() {
    intsToEvenOddCSVs();
  }

  // [TEST] intsToEvenOddCSVs()
  @Test
  void intsToEvenOddCSVs() {
    Integer testCount = 1;
String testName = "week1.day5 - EvenOddCSVs.class | intsToEvenOddCSVs()";

    // Test Cases
    int[][] testCases = {
      { 1, 2, 3, 4 }, // Standard
      { 30, 42, 0, 7 }, // Zero
      { -1, -42, 93, 6 }, // Negative
      { 40001, 8, 11, 64 },
      { 59, 12, 290, 25 },
    };

    // Test Results
    String[] testResults = {
      "o1,e2,o3,e4",
      "e30,e42,e0,o7",
      "o-1,e-42,o93,e6",
      "o40001,e8,o11,e64",
      "o59,e12,e290,o25",
    };

    // Test
    Runnable test = () -> {
for (int i = 0; i < testCases.length; i++) {
        String expected = testResults[i];
        String actual = EvenOddCSVs.intsToEvenOddCSVs(testCases[i]);
        System.out.println(i + ": " + expected + " | " + actual);
        assertNotNull(actual);
        assertEquals(expected, actual);
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }
}
