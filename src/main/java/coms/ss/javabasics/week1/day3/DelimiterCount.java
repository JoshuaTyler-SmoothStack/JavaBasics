package coms.ss.javabasics.week1.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads a text-file input, logging the count of a specific delimiter
 *
 * @author Joshua Tyler
 */
public class DelimiterCount {

  /**
   * Uses the FileReader to parse and println() the count of a
   * specified delimiter (or "\n" if no args)
   *
   * @param args - string path ("lorem" for local LoremIpsum.txt), string[] delimiter
   */
  public static void main(String[] args) {
    // Cancel if args invalid
    if (args == null || args.length < 1) {
      System.err.println(
        "\n Please specificy a path and one or more delimiters to count."
      );
      System.out.println(
        "\n Use the argument 'lorem' as the path to use the local LoremIpsum.txt file"
      );
      return;
    }

    // Determine to use LoremIpsum.txt or other specific text document
    String path = ("lorem".equals(args[0]))
      ? System.getProperty("user.dir").replace("\\", "/") +
      "/src/com/ss/week1/day3/LoremIpsum.txt"
      : args[0];

    // If no delimiter is specified, use "\n"
    String[] delimiters = (args.length < 2)
      ? new String[] { " ", "\n" } // set in delimiters[1] to avoid changing code for args[]
      : args;

    // Read the file, and parse for the delimiters
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      StringBuilder documentTextBuilder = new StringBuilder();
      String lineText;
      while ((lineText = br.readLine()) != null) {
        documentTextBuilder.append(lineText + "\n");
      }
      String documentText = documentTextBuilder.toString();

      for (int i = 1; i < delimiters.length; i++) {
        int delimiterCount = countMatches(documentText, delimiters[i]);
        System.out.println(
          "\n" +
          delimiterCount +
          " instances found of delimiter: " +
          delimiters[i].toString()
        );
      }
    } catch (IOException error) {
      System.err.println("Unable to find file path! " + path);
    }
  }

  /**
   * Counts how many times the char appears in the given string
   *
   * @param str the String to check
   * @param sub  the sub String to count
   * @return the number of occurrences
   */
  public static int countMatches(String str, String sub) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.substring(i, i + sub.length()).equals(sub)) {
        count++;
      }
    }
    return count;
  }
}
