package coms.ss.javabasics.week1.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
   * Uses the FileReader to parse and println() the filename's of all files within
   * the specifiec directory (or src if no args)
 *
 * @author Joshua Tyler
 */
public class ListDirectoryFiles {

  /**
   * Main Driver
   *
   * @param args - string absolute file location
   */
  public static void main(String[] args) {
    String path = (args != null && args.length > 0)
      ? args[0]
      : System.getProperty("user.dir");
    try (Stream<Path> subPaths = Files.walk(Paths.get(path), 1)) {
      subPaths.forEach(subPath -> System.out.println(subPath));
    } catch (IOException error) {
      System.err.println("Unable to find file path! " + path);
    }
  }
}
