package coms.ss.javabasics.week1.assignment2;

import java.util.List;
import java.util.stream.Collectors;

public class RightMostDigits {
  
  public static List<Integer> rightMostDigits(List<Integer> input) {
    return input.stream().map((value) -> value % 10).collect(Collectors.toList());
  }

}
