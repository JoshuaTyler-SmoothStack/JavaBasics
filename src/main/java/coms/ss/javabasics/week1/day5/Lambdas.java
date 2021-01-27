package coms.ss.javabasics.week1.day5;

import java.util.Arrays;
import java.util.Comparator;

public class Lambdas {

  public static String[] sortAlphabetically(String[] array) {
    Arrays.sort(array);
    return array;
  }

  public static String[] sortLengthSmallest(String[] array) {
    Arrays.sort(array, Comparator.comparing(String::length));
    return array;
  }

  public static String[] sortLengthLargest(String[] array) {
    Arrays.sort(array, Comparator.comparing(String::length).reversed());
    return array;
  }

  public static String[] sortWithE(String[] array) {
    Arrays.sort(array, Comparator.comparing(str -> !str.contains("e")));
    return array;
  }

  public static String[] sortWithEUtils(String[] array) {
    Arrays.sort(array, (str1, str2) -> EUtils.containsE(str1, str2));
    return array;
  }

  private static class EUtils {
    public static int containsE(String str1, String str2) {
      boolean str1HasE = str1.contains("e");
      boolean str2HasE = str2.contains("e");
      if(str1HasE && str2HasE) {
        return 0;
      } else if(str1HasE) {
        return -1;
      } else {
        return 1;
      }
    }
  }
}
