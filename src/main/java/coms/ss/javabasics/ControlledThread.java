package coms.ss.javabasics;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Adds quality of life for easily monitoring and stopping threads safely
 * - isRunning: to indicate state
 * - onInterrupt: for safe cleanup
 * - onExecute: holds the core function
 * - statusCheckInterval: how frequent the thread checks isRunning
 * - threadName: to help with tracking the thread through its lifecycle
 * 
 * @author Joshua Tyler
 */
public class ControlledThread implements Runnable {

  private AtomicBoolean isRunning = new AtomicBoolean(false);
  private Runnable onInterrupt;
  private Runnable onExecute;
  private int statusCheckInterval;
  private String threadName;
  private Thread worker;

  public ControlledThread(Runnable _onExecute, Runnable _onInterrupt, String _threadName, int _statusCheckInterval) {
    onInterrupt = _onInterrupt;
    onExecute = _onExecute;
    statusCheckInterval = _statusCheckInterval;
    threadName = _threadName;
  }

  public void interrupt() {
    isRunning.set(false);
    worker.interrupt();
    onInterrupt.run();
  }

  public boolean isRunning() {
    return isRunning.get();
  }

  public String threadName() {
    return threadName;
  }

  public void run() {
    worker = new Thread(() -> {
      isRunning.set(true);
      while (isRunning.get()) {
        try {
          Thread.sleep(statusCheckInterval);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        onExecute.run();
      }
      isRunning.set(false);
    });
    worker.start();
  }
}