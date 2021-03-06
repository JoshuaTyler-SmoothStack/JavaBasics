package coms.ss.javabasics.week1.day5;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeLetterAWord {
  
  public static List<String> getThreeLetterWordsStartingWithLowercaseA(List<String> words) {
    return words.stream().filter((str) -> { 
      Boolean containsA = str.contains("a");
      Boolean isThreeLetters = (str.length() == 3);
      if(containsA && isThreeLetters) {
        return true;
      }
      return false;
    }).collect(Collectors.toList());
  }
}
