package coms.ss.javabasics.week1.day5;

public class EvenOddCSVs {
  
  public static String intsToEvenOddCSVs(int[] array) {
    StringBuilder sb = new StringBuilder();
    for(int i : array) {
      boolean isOdd = (i % 2) != 0;
      sb.append((sb.length() < 1 ? "" : ",") + (isOdd ? "o" : "e") + i);
    }
    return sb.toString();
  }
}