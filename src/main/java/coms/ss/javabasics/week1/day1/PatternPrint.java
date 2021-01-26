package coms.ss.javabasics.week1.day1;

/**
 * Takes a count of '*' (stars) and organizes them into a
 * specific string format to be logged in the console.
 * 
 * @author Joshua Tyler
 */

class PatternPrint {

  final static Integer FIRST_STAR_COUNT = 4;
  final static Integer SECOND_STAR_COUNT = 7;

  /**
   *  Sets the formatting parameters to create the strings
   *  and calls the println()'s
   * 
   * @param args - unused
   */
  public static void main(String[] args) {
    String firstString  = constructString(FIRST_STAR_COUNT, false, false);
    String secondString = constructString(FIRST_STAR_COUNT, false, true);
    String thirdString  = constructString(SECOND_STAR_COUNT, true, false);
    String fourthString = constructString(SECOND_STAR_COUNT, true, true);
    
    System.out.println("\n1)" + firstString);
    System.out.println("\n2)" + secondString);
    System.out.println("\n3)" + thirdString);
    System.out.println("\n4)" + fourthString);
  }

    /**
   *  Compares the user's input value. Checks that it is a valid int and
   *  is within the range of 1-100. Determines if the input is correct,
   *  close, or far off enough for a hint. If the user has no guesses remaing,
   *  reports correct answer.
   * 
   * @param starCount - the max # of *'s
   * @param isSpaced - determines if the *'s are aligned with whitespace
   * @param isFlipped - determines if the strings are mirrored vertically
   */
  private static String constructString(Integer starCount, Boolean isSpaced, Boolean isFlipped) {
    String dots = isFlipped ? "\n.........." : "\n.........";
    String stars = "";

    // Iterate the starCount
    for(int i = 1; i <= starCount; i++) {
      String newLine = "\n";
      
      // Add Spacing if applicable
      if(isSpaced) {
        // Skip even numbers if isSpaced
        if(i % 2 == 0) {
          continue;
        }

        // Calculate the offset and add that number of spaces
        Integer spaceCount = (int)((starCount-i)/2) + 1;
        for(int iSpaces = 0; iSpaces < spaceCount; iSpaces++) {
          newLine += " ";
        }
      }

      // Add i amount of stars
      for(int iStars = 0; iStars < i; iStars++) {
        newLine += "*";
      }


      // Add the newLine to the stars string
      if(isFlipped) {
        stars = newLine + stars;
      } else {
        stars += newLine;
      }

    }

    // If reversed, dots and then stars : stars and then dots
    return isFlipped ? (dots + stars) : (stars + dots);
  }
}
