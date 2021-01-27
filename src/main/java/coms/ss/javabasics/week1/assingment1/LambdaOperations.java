package coms.ss.javabasics.week1.assingment1;

import java.util.stream.IntStream;

public class LambdaOperations {

  public static PerformOperation isOdd() {
    return num -> num % 2 != 0 ? "TRUE" : "FALSE";
  }

  public static PerformOperation isPrime() {
    return num ->
      (
          num > 1 &&
          IntStream.range(2, num - 1).noneMatch(index -> num % index == 0)
        )
        ? "TRUE"
        : "FALSE";
  }

  public static PerformOperation isPalindrome() {
    return num -> {
      StringBuilder sb = new StringBuilder();
      sb.append(num);
      String numToString = sb.toString();
      String reversed = sb.reverse().toString();
      return numToString.equals(reversed) ? "TRUE" : "FALSE";
    };
  }

  public static String handleInput(String input) {
    String[] splitInput = input.split("\n");
    int numberOfTests = Integer.parseInt(splitInput[0]);

    for (int testNum = 0; testNum < numberOfTests; testNum++) {
      Integer condition = Integer.parseInt(splitInput[(testNum * 2) + 1]);
      Integer value = Integer.parseInt(splitInput[(testNum * 2) + 2]);

      switch (condition) {
        case 1:
          return isOdd().apply(value);
        case 2:
          return isPrime().apply(value);
        case 3:
          return isPalindrome().apply(value);
      }
    }
    return "Test Complete!";
  }
}
