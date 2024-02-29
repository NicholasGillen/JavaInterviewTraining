import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

//Fibonacci - Implement a function fibonacci(int x) that returns the xth number in the fibonacci sequence. Must be order N time complexity and order 1 space complexity.

public class Solution {

  @Test
  public void smallFibonnaci_5() {
    int calculatedValue = fibonacci(5);
    int expectedValue = 5;
    assertEquals(expectedValue, calculatedValue);
  }

  @Test
  public void smallFibonnaci_7() {
    int calculatedValue = fibonacci(7);
    int expectedValue = 13;
    assertEquals(expectedValue, calculatedValue);
    return;
  }

  @Test
  public void bigFibonnaci_25() {
    int calculatedValue = fibonacci(25);
    int expectedValue = 75025;
    assertEquals(expectedValue, calculatedValue);
    return;
  }


  public int fibonacci(int x) {
    if (x == 0 ) return 0;
    if (x == 1) return 1;

    int previousPrevious = 0;
    int previous = 1;
    int current = 0;
    for (int i = 2; i <= x; i++) {
      current = previousPrevious + previous;
      previousPrevious = previous;
      previous = current;
    }
    return current;
  }


  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
