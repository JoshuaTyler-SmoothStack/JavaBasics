package coms.ss.javabasics.week1.day2;

import java.util.Random;

/**
 * Construct a 2D Array, find the max value in the array
 * and println()'s the max value's position
 *
 * @author iioshua Tyler
 */
public class TwoDimensionalMaxValue {

  /**
   * Creates a 2D array of random values. Iterates the 2D array to find
   * the max value and println()'s the max value's value and position
   *
   * @param args - unused
   */
  public static void main(String[] args) {
    int[][] random2DArray = create2DArray();
    int[] results = find2DArrayMaxValue(random2DArray);
    System.out.println(
      "Max Value: " +
      results[0] +
      "\nPosition: [" +
      results[1] +
      "][" +
      results[2] +
      "]"
    );
  }

  /**
   * Create a 2D Array of random numbers
   *
   * @return 2D Array
   */
  public static int[][] create2DArray() {
    Random rand = new Random();

    // Determine 2 random lengths for the array
    int lengthX = rand.nextInt(10) + 1;
    int lengthY = rand.nextInt(10) + 1;

    // Create the 2D Array, assigning random values 1-100
    int[][] newArray = new int[lengthX][lengthY];
    for (int i = 0; i < lengthX; i++) {
      for (int ii = 0; ii < lengthY; ii++) {
        newArray[i][ii] = rand.nextInt(100) + 1;
      }
    }
    return newArray;
  }

  /**
   * Interate over a 2D Array, finding its max value
   * and the max value's index
   *
   * @param int[][] - 2D Array
   * @return int[] - int[0] = value && int[1] = index1 && int[2] = index2
   */
  public static int[] find2DArrayMaxValue(int[][] input) {
    int maxValue = 0;
    int maxValueX = 0;
    int maxValueY = 0;

    for (int i = 0; i < input.length; i++) {
      for (int ii = 0; ii < input[i].length; ii++) {
        int value = input[i][ii];
        if (value > maxValue) {
          maxValue = value;
          maxValueX = i;
          maxValueY = ii;
        }
      }
    }
    int[] output = { maxValue, maxValueX, maxValueY };
    return output;
  }
}
