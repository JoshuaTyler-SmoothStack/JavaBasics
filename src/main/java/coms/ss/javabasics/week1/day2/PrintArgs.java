package coms.ss.javabasics.week1.day2;

/**
 * Takes in input from the command line, summing all valid numbers
 *
 * @author Joshua Tyler
 */
public class PrintArgs {

  /**
   * Sums valid number type args, notifies user of invalid args
   *
   * @param args - number types
   */
  public static void main(String[] args) {
    Boolean minOneValidArgs = false;
    Float summedArgs = 0f;

    // Notify the user if the args are null or cannot be summed
    if (args == null) {
      System.err.println("Invalid Args - null");
      return;
    }

    // Interate Args, trying parseFloat - notifying user if invalid input
    for (int i = 0; i < args.length; i++) {
      Float inputFloat = null;
      try {
        inputFloat = Float.parseFloat(args[i]);
        summedArgs += inputFloat;
        minOneValidArgs = true;
      } catch (NumberFormatException error) {
        System.out.println("Invalid Arg - not a number: " + args[i]);
      }
    }

    // Inform the user of the sum, or if no args were summed
    if (minOneValidArgs) {
      System.out.println("Args sum: " + Math.round(summedArgs));
    } else {
      System.out.println(
        "Unable to calculate a sum, no valid numbers present in args."
      );
    }
  }
}
