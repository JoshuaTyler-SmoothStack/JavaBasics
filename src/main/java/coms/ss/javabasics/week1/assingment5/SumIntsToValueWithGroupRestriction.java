package coms.ss.javabasics.week1.assingment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumIntsToValueWithGroupRestriction {
  
  public static boolean groupSumClump(Integer[] array, Integer value) {
    //List<Integer> clumpedValues = getClumpedValues(array);
    return canSumToValue(array, value);
  }

  public static boolean canSumToValue(Integer[] array, Integer value) {
    // Create a HashMap of the possible shallow sums
    // Check if any of the array indexes are the value
    // Also checking the totalSum to see if the value is a possibility
    int totalSum = 0;
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for(int i = 0; i < array.length; i++) {
      Integer value1 = array[i];
      
      totalSum += value1;
      if(value1 == value) {
        return true;
      }

      // Sum with other indexes (not self) and add to HashMap
      for(int ii = 0; ii < array.length; ii++) {
        if(ii != i) {
          Integer value2 = array[ii];
          map.put((value1 + "," + value2), value1+value2);
        }
      }
    }
    if(totalSum < value) {
      return false;
    }

    // Check if the shallow sums contains the value
    if(map.values().contains(value)) {
      return true;
    }

    // Iterate through the array, passing the HashMap 
    for(int i : array) {
      List<Integer> rowSums = calculateHashMapRowSums(map, i);
      if(rowSums.contains(value)) {
        return true;
      }
    }
    return false;
  }

  public static List<Integer> calculateHashMapRowSums(HashMap<String, Integer> map, Integer row) {
    List<Integer> rowSums = new ArrayList<Integer>();

    // [i]th row values are ignored as to not sum with itself
    // the marker "d" identifies duplicate rows so they are not overlooked
    for(String key : map.keySet()) {
      if(!key.contains(row+"") || key.contains(row+"d")) {
        int sum = row + map.get(key);
        if(!rowSums.contains(sum)) {
          rowSums.add(sum);
        }
      }
    }
    return rowSums;
  }

  public static List<Integer> getClumpedValues(Integer[] array) {
    List<Integer> clumpedValues = new ArrayList<Integer>();
    for(int i = 0; i < array.length; i++) {
      if(i + 1 > array.length) {
        break;
      }

      if(array[i] == array[i+1] && !clumpedValues.contains(array[i])){
        clumpedValues.add(array[i]);
        i++;
      }
    }
    return clumpedValues;
  }
}
