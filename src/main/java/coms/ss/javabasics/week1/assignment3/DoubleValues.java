package coms.ss.javabasics.week1.assignment3;

import java.util.List;
import java.util.stream.Collectors;

public class DoubleValues {
  public static List<Integer> rightMostDigits(List<Integer> input) {
    return input.stream().map((value) -> value * 2).collect(Collectors.toList());
  }
}
