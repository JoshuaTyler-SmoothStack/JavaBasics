package coms.ss.javabasics.week1.assingment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Determines if it is possible to sum items from an array
 * of ints to a target valueToSum. This is performed with the
 * additional constraint that any adjacent identical values
 * are either all used or none of them are used.
 *
 * @author Joshua Tyler
 */
public class Recursion {

  /**
   * Driver for combining functionality of grouping constraint
   * and then applying the summing logic.
   *
   * @param array - Integer[] of values to pull from
   * @param valueToSum - Integer valueToSum to test if sum is possible
   * @return bool sum is possible
   */
  public static boolean groupSumClump(Integer[] array, Integer valueToSum) {
    Integer[] deClumpedValues = getDeClumpedValues(array);
    return canSumToValue(deClumpedValues, deClumpedValues.length, valueToSum);
  }

  /**
   * Recursively shrinks the array and subtracts from the sumToValue until
   * the array length is 0 or the sumToValue is 0. When the sumToValue is 0,
   * it indicates that preceding instances can be added together to equal
   * the sumToValue.
   *
   * e.g.
   * (2, 4, 8) => 14 - true
   * (2, 4, 8) => 15 - false
   *
   *
   * @param array - Integer[] of values to pull from
   * @param instanceLength - Integer of the length of the array being utilized
   * @param sumToValue - Integer valueToSum to test if equal to
   * @return bool sum is possible
   */
  public static boolean canSumToValue(
    Integer[] array,
    int instanceLength,
    int sumToValue
  ) {
    // Base Cases
    if (sumToValue == 0) {
      return true;
    } else if (instanceLength == 0) {
      return false;
    }

    // If last index is greater than the sumToValue, ignore it
    if (array[instanceLength - 1] > sumToValue) {
      return canSumToValue(array, instanceLength - 1, sumToValue);
    }
    // Else, check if the sumToValue is reached with the current instance
    else if (canSumToValue(array, instanceLength - 1, sumToValue)) {
      return true;
    }

    // Else, check if the sumToValue is reached by excluding an element
    return canSumToValue(
      array,
      instanceLength - 1,
      sumToValue - array[instanceLength - 1]
    );
  }

  /**
   * Finds identical adjacent values in an array and returns
   * them as a HashMap
   *
   * @param array - Integer[] of values to test
   * @return HashMap<Integer, Integer> identical adjacent values
   */
  public static HashMap<Integer, Integer> getClumpedValues(Integer[] array) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      if (hasAdjacentIdenticals(array, i)) {
        int clumpCount = 1;
        if (map.get(array[i]) != null) {
          clumpCount = map.get(array[i]) + 1;
        }
        map.put(array[i], clumpCount);
      }
    }
    return map;
  }

  /**
   * Finds identical adjacent values in an array and returns and 
   * combines them into the sum of their wholes.
   *
   * @param array - Integer[] of values to deClump
   * @return Integer[] of values without clumps
   */
  public static Integer[] getDeClumpedValues(Integer[] array) {
    HashMap<Integer, Integer> clumpedValues = getClumpedValues(array);
    List<Integer> encountered = new ArrayList<Integer>();
    List<Integer> deClumpedValues = new ArrayList<Integer>();

    // Create the new deClumpedValues
    for (int i = 0; i < array.length; i++) {
      Integer current = array[i];

      // Non-Clumped values
      if (!clumpedValues.keySet().contains(current)) {
        deClumpedValues.add(current);
      }
      // Clumped Values
      else {
        // Ignore non-AdjacentIdenticals
        if (!hasAdjacentIdenticals(array, i)) {
          deClumpedValues.add(current);
        }
        // Ignore clumpedValues already encountered
        else if (!encountered.contains(current)) {
          encountered.add(current);
          deClumpedValues.add(current * clumpedValues.get(current));
        }
      }
    }
    return deClumpedValues.toArray(new Integer[0]);
  }

  /**
   * Finds identical adjacent values in an array and returns
   * true/false if identical adjacent values are present
   *
   * @param array - Integer[] of values to test
   * @param index - Integer index of array to test for adjacent identicals
   * @return bool - identical adjacent values present
   */
  public static Boolean hasAdjacentIdenticals(Integer[] array, Integer index) {
    Integer current = array[index];
    Boolean isPrevIdentical = false;
    if (index - 1 > -1) {
      isPrevIdentical = current == array[index - 1];
    }

    Boolean isNextIdentical = false;
    if (index + 1 < array.length) {
      isNextIdentical = current == array[index + 1];
    }
    return (isPrevIdentical || isNextIdentical);
  }
}
