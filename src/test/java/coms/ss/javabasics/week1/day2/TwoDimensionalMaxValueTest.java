package coms.ss.javabasics.week1.day2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import coms.ss.javabasics.KitUtils;
import coms.ss.javabasics.TestUtils;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class TwoDimensionalMaxValueTest {

  @Test
  public void runAllTests() {
    createRandom2DArray();
    find2DArrayMaxValueAndPosition();
  }

  @Test
  void createRandom2DArray() {
    Integer testCount = 1;
    String testName =
      "week1.day2 - TwoDimensionalMaxValue.class | createRandom2DArray()";

    // Test
    Runnable test = () -> {
      for (int testCase = 0; testCase < 3; testCase++) {
        Integer[][] actual = TwoDimensionalMaxValue.createRandom2DArray();
        assertNotNull(actual);
        Boolean expected = (actual.length > 0) && (actual[0].length > 0);
        if (expected) {
          for (int i = 0; i < actual.length; i++) {
            // prettier-ignore
            System.out.println(
              testCase + ": Generated[" + i + "][x]: " + 
              KitUtils.toString(actual[i])
            );
          }
        } else {
          fail();
        }
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }

  @Test
  void find2DArrayMaxValueAndPosition() {
    Integer testCount = 1;
    String testName =
      "week1.day2 - TwoDimensionalMaxValue.class | find2DArrayMaxValueAndPosition()";

    Runnable test = () -> {
      for (int testCase = 0; testCase < 5; testCase++) {
        Integer[][] testCases = TwoDimensionalMaxValue.createRandom2DArray();
        Integer[] actual = TwoDimensionalMaxValue.find2DArrayMaxValueAndPosition(
          testCases
        );
        assertNotNull(actual);

        // Find 2D max without position
        Integer expected = 0;
        for (int i = 0; i < testCases.length; i++) {
          Integer xIndex = i;
          Integer thisMax = IntStream
            .range(0, testCases[xIndex].length)
            .map(ii -> testCases[xIndex][ii])
            .max()
            .getAsInt();
          if (thisMax > expected) {
            expected = thisMax;
          }
        }

        Integer valueAtActualPosition = testCases[actual[1]][actual[2]];
        Boolean isMaxValid = expected == actual[0];
        Boolean isPositionValid = valueAtActualPosition == expected;

        // prettier-ignore
        String result = 
        testCase + ": Generated " + testCases.length + 
        " arrays of " + testCases[0].length +
        " values, with a Max Value of: " + expected + 
        " | found position: (" + actual[1] + "," + actual[2] +
        ") with value: " + valueAtActualPosition;

        if (isMaxValid && isPositionValid) {
          System.out.println(result);
        } else {
          System.err.println(result);
        }
      }
    };
    TestUtils.runTest(test, testName, testCount);
  }
}
