package coms.ss.javabasics;

import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import coms.ss.javabasics.week1.assignment5.RecursionTest;
import coms.ss.javabasics.week1.day2.TwoDimensionalMaxValueTest;
import coms.ss.javabasics.week1.day4.LineTest;
import coms.ss.javabasics.week1.day5.EvenOddCSVsTest;
import coms.ss.javabasics.week1.day5.LambdasTest;
import coms.ss.javabasics.week1.day5.ThreeLetterAWordTest;

// @SpringBootTest
class JavabasicsApplicationTests {

  @Test
  void runAllTests() {
    //region ==== Week 1
      // Day 1
      // [GuessNumber] - run is test case (uses JFrame UI)
      // [PatternPrint] - run is test case (displays pattern to console)

      // Day 2
      new TwoDimensionalMaxValueTest().runAllTests();

      // Day 3
      // [AppendTextToFile] - run is test case (writes to files)
      // [DelimiterCount] - run is test case (reads files)
      // [ListDirectoryFiles] - run is test case (reads files)

      // Day 4
      // [Deadlock] - run test case (creates thread deadlock - breaking after 5 seconds)
      // [ProducerConsumer] - run is test case (rapidly procudes and consumes random Integers)
      new LineTest().runAllTests();
      // [Singleton] - no test case

      // Day 5
      new EvenOddCSVsTest().runAllTests();
      new LambdasTest().runAllTests();
      new ThreeLetterAWordTest().runAllTests();

      // Assignment 1
      // Assignment 2
      // Assignment 3

      // Assignment 4
      

      // Assignment 5
      new RecursionTest().runAllTests();

      // Assignment 6
      // [FixThisSingleton] - no test case
    //endregion

    //region ==== Week 2
  }
}
