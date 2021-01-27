package coms.ss.javabasics.week1.assingment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Determines if it is possible to sum items from an array
 * of ints to a target value. This is performed with the
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
   * @param value - Integer value to test if sum is possible
   * @return bool sum is possible
   */
  public static boolean groupSumClump(Integer[] array, Integer value) {
    String[] clumpedValues = getClumpedValues(array);
    List<Integer> deClumpedArray = new ArrayList<Integer>();

    // Iterarte through the array, restructuring clumpedValues as the
    // sum of their whole (as clumpedValues are inclusive or excluseive)
    for(int i = 0; i < clumpedValuesArray.length; i++) {
      clumpedValues.add(clumpedValuesArray[i][0]);
    }

    for(int i = 0; i < array.length; i++) {
      if(clumpedValues)
      deClumpedValues.add(clumpedValuesArray[i][0]);
    }


    return false;
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
   * @param sumToValue - Integer value to test if equal to
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
   * them as a List<Integer>
   *
   * @param array - Integer[] of values to test
   * @return List<Integer> identical adjacent values
   */
  public static String[] getClumpedValues(Integer[] array) {    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < array.length; i++) {
      if (i + 1 > array.length - 1) {
        break;
      }

      if (array[i] == array[i + 1]) {
        int startIndex = i;
        int endIndex = i+1;
        if(map.get(array[i]) != null) {
          clumpCount += map.get(array[i])-1;
        }
        map.put(array[i], clumpCount);
      }
    }

    Integer[][] clumpedValues = new Integer[map.values().size()][2];
    Integer count = 0;
    for(Integer key : map.keySet()) {
      clumpedValues[count][0] = key;
      clumpedValues[count][1] = map.get(key);
      count++;
    }
    return clumpedValues;
  }
}
