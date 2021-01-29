package coms.ss.javabasics.week1.day4;

import coms.ss.javabasics.ControlledThread;
import coms.ss.javabasics.KitUtils;

/**
 * Creates a deadlock between two threads awaiting the value being held by the
 * other. Threads stop after 5 seconds.
 *
 * @author Joshua Tyler
 */
public class Deadlock {

  /**
   * Driver for starting the two threads trying to use synchronized Objects, thus
   * creating a thread deadlock.The threads will be stopped if alive after 5
   * seconds has elapsed.
   *
   * @param args - unused
   */
  public static void main(String[] args) {
    Deadlock deadLock = new Deadlock();
    int lockObj1 = 1;
    int lockObj2 = 2;
    ControlledThread thread1 = deadLock.createDeadlockThread(
      lockObj1,
      lockObj2,
      "1"
    );
    ControlledThread thread2 = deadLock.createDeadlockThread(
      lockObj2,
      lockObj1,
      "2"
    );
    thread1.run();
    thread2.run();

    KitUtils.setTimeout(
      () -> {
        if (thread1.isRunning() && thread2.isRunning()) {
          System.out.println(
            "Both threads detected locked after 5 seconds.\nDisabling threads . . ."
          );
          thread1.interrupt();
          thread2.interrupt();
          System.exit(0);
        }
      },
      5000
    );

    // End Function
    // =============================================================
    //region UI Readouts (non-functional)
    KitUtils.setTimeout(
      () -> {
        if (thread1.isRunning() && thread2.isRunning()) {
          System.out.println("Both threads detected locked after 1 second.");
        }
      },
      1000
    );

    KitUtils.setTimeout(
      () -> {
        if (thread1.isRunning() && thread2.isRunning()) {
          System.out.println("Both threads detected locked after 2 seconds.");
        }
      },
      2000
    );

    KitUtils.setTimeout(
      () -> {
        if (thread1.isRunning() && thread2.isRunning()) {
          System.out.println("Both threads detected locked after 3 seconds.");
        }
      },
      3000
    );

    KitUtils.setTimeout(
      () -> {
        if (thread1.isRunning() && thread2.isRunning()) {
          System.out.println("Both threads detected locked after 4 seconds.");
        }
      },
      4000
    );
    //endregion
  }

  /**
   * A thread which accesses an Object, sleeps 100 ms, and then accesses a 2nd
   * Object. Using two threads with this runnable and the Object's ordering
   * swapped will result in dead locking.
   *
   * @param lockObj1   - object to be locked before sleep
   * @param lockObj2   - object to be locked after sleep
   * @param threadName - string name of thread to println()
   * @return - Thread to be used for deadlocking
   */
  public ControlledThread createDeadlockThread(
    Object lockObj1,
    Object lockObj2,
    String threadName
  ) {
    Runnable onExecute = () -> {
      try {
        synchronized (lockObj1) {
          Thread.sleep(100);
          synchronized (lockObj2) {
            System.out.println("Thread: " + threadName + " is running.");
          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Runnable onInterrupt = () -> {
      System.out.println("Thread: " + threadName + " interrupted!");
    };

    ControlledThread thread = new ControlledThread(
      onExecute,
      onInterrupt,
      threadName,
      200
    );
    return thread;
  }
}
