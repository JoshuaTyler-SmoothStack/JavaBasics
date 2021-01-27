package coms.ss.javabasics.week1.day4;

/**
 * Implements a Singleton with double-checked locking
 *
 * @author Joshua Tyler
 */
public class Singleton {

  private static volatile Singleton _instance = null;

  public static Singleton getInstance() {
    synchronized (_instance) {
      if (_instance == null) {
        _instance = new Singleton();
      }
    }
    return _instance;
  }
}
