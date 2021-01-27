package coms.ss.javabasics.week1.assignment4;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveX {
    
  public static List<String> rightMostDigits(List<String> input) {
    return input.stream().map((str) -> str.replace("x", "")).collect(Collectors.toList());
  }
}
