import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Child Climbing Steps (modified Fibonacci)
// A child is climbing a set of steps n high.
// The child wants to have fun, so they will try to climb the steps in different jumps. Sometimes they will jump up one step, sometimes two steps, and sometimes three steps.
// Your task is to calculate the *number* of permutations combinations of jumps that will allow the child to reach the top of the steps.
// For example for a set of 3 steps, the child could jump
// 1 step followed by 1 step followed by 1 step
// 2 steps followed by 1 step
// 1 step followed by 2 steps
// 3 steps
// So the answer would be 4.

public class Solution {

  @Test
  public void simpleTest1() {
    int target = 3;
    int expected = 4;
    int calculated = calculateNumberOfPermutations(target);

    assertEquals(expected, calculated);
  }

  @Test
  public void simpleTest2() {
    int target = 4;
    int expected = 7;
    int calculated = calculateNumberOfPermutations(target);

    assertEquals(expected, calculated);
  }

  @Test
  public void boundaryTest1() {
    int target = 1;
    int expected = 1;
    int calculated = calculateNumberOfPermutations(target);

    assertEquals(expected, calculated);
  }

  @Test
  public void boundaryTest2() {
    int target = 2;
    int expected = 2;
    int calculated = calculateNumberOfPermutations(target);

    assertEquals(expected, calculated);
  }

  @Test
  public void boundaryTest3() {
    int target = 3;
    int expected = 4;
    int calculated = calculateNumberOfPermutations(target);

    assertEquals(expected, calculated);
  }

  public int calculateNumberOfPermutations(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    if (n == 2) {
      return 1 + calculateNumberOfPermutations(n - 1);
    }

    if (n == 3) {
      return 1 + calculateNumberOfPermutations(n - 1) + calculateNumberOfPermutations(n - 2);
    }

    return calculateNumberOfPermutations(n - 1) + calculateNumberOfPermutations(n - 2) + calculateNumberOfPermutations(n - 3);

  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}