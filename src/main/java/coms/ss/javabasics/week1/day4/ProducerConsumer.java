package coms.ss.javabasics.week1.day4;

import coms.ss.javabasics.ControlledThread;
import coms.ss.javabasics.KitUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates a producer thread and consumer thread. The producer creates values as
 * needed, the consumer thread pulls values.
 *
 * @author Joshua Tyler
 */
public class ProducerConsumer {

  private static volatile List<Integer> buffer;

  /**
   * Driver for creating & starting the two threads; then disabling them after 10
   * seconds has elapsed.
   *
   * @param args - (optional) time in milliseconds of each cycle (recommended range: 100 - 1000)
   */
  public static void main(String[] args) {
    buffer = new ArrayList<Integer>();
    Random rand = new Random();

    // Determine whether or not to use the args input for cycleTime
    Boolean useArgs = true;
    if (args.length > 0) {
      try {
        Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
        useArgs = false;
      }
    } else {
      useArgs = false;
    }
    Integer cycleTime = useArgs ? Integer.parseInt(args[0]) : 100;

    // Producer
    Runnable produceExecute = () -> {
      while (buffer.size() < 10) {
        synchronized (buffer) {
          int produceValue = rand.nextInt(100) + 1;
          buffer.add(produceValue);
          System.out.println("Produced: " + produceValue);
        }
      }
    };

    // Consumer
    Runnable consumeExecute = () -> {
      while (buffer.size() > 9) {
        synchronized (buffer) {
          int consumeValue = buffer.get(0);
          buffer.remove(0);
          System.out.println("Consumed: " + consumeValue);
        }
      }
    };

    // Interrupters - Optional
    Runnable produceInterrupt = () -> {
      System.out.println("Producer interrupted!");
    };

    Runnable consumeInterrupt = () -> {
      System.out.println("Consumer interrupted!");
    };

    // Start the Threads
    ControlledThread producer = new ControlledThread(
      produceExecute,
      produceInterrupt,
      "producer",
      cycleTime
    );
    ControlledThread consumer = new ControlledThread(
      consumeExecute,
      consumeInterrupt,
      "consumer",
      cycleTime
    );
    producer.run();
    consumer.run();

    // Stop the Threads after 10 seconds has elapsed
    KitUtils.setTimeout(
      () -> {
        producer.interrupt();
        consumer.interrupt();
      },
      10000
    );
  }
}
