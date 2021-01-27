package coms.ss.javabasics.week1.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Takes in input from the command line, summing all valid numbers
 *
 * @author Joshua Tyler
 */
public class AppendTextToTextFile {

  /**
   * Uses the Files API to write the args and into
   * a local file called "Output.txt"
   *
   * @param args - string absolute file location
   */
  public static void main(String[] args) {
    if (args == null || args.length < 1) {
      System.err.println(
        "Invalid Args - please include text to be appended to 'Output.txt'"
      );
      return;
    }

    String path =
      System.getProperty("user.dir").replace("\\", "/") +
      "/src/com/ss/week1/day3/Output.txt";
    StringBuilder textBuilder = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      textBuilder.append(args[i].toString() + " ");
    }
    String text = "\n" + textBuilder.toString();

    try {
      Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException error) {
      error.printStackTrace();
    }
  }
}
