package coms.ss.javabasics;

/**
 * Adds a quality of life library for commonly used static methods
 *
 * @author Joshua Tyler
 */
public class KitUtils {

  /**
   * A thread which sleeps for the specific time (ms), and then performs the
   * passed Runnable
   *
   * @param runnable - runnable to be executed after delay
   * @param delay    - int time in milliseconds to delay the runnable
   */
  public static void setTimeout(Runnable runnable, int delay) {
    new Thread(
      () -> {
        try {
          Thread.sleep(delay);
          runnable.run();
        } catch (Exception e) {
          System.err.println(e);
        }
      }
    )
      .start();
  }

  public static String arrayToString(Object[] array) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < array.length; i++) {
      sb.append(array[i].toString() + (i < array.length-1 ? ", " : ""));
    }
    return sb.toString();
  }
}
