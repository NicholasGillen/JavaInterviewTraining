import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Fibonacci with memoization

public class Solution {

  @Test
  public void test1() {
    int n = 9;
    int expected = 34;
    int calculated = fib(n, new HashMap<Integer, Integer>());

    assertEquals(expected, calculated);
  }
  
  @Test
  public void largeNumber() {
    int n = 40;
    int expected = 102334155;
    int calculated = fib(n, new HashMap<Integer, Integer>());

    assertEquals(expected, calculated);
  }

    @Test
  public void largeNumberSeparatedFunction() {
    int n = 40;
    int expected = 102334155;
    int calculated = fibWithSeparateMemoParameterFunction(n);

    assertEquals(expected, calculated);
  }

  @Test
  public void largeNumberWithoutMemo() {
    int n = 40;
    int expected = 102334155;
    int calculated = fibWithoutMemo(n);

    assertEquals(expected, calculated);
  }

  public int fib(int n, HashMap<Integer, Integer> memoCache) {

    // HashMap<Integer, Integer> memoCache = new HashMap<>();
    if (n == 0) return 0;
    if (n == 1) return 1;

    if (memoCache.containsKey(n)) {
      System.out.println("Accessing value of fib" + n);
      return memoCache.get(n);
    }
    else {
      int result = fib(n-1, memoCache) + fib(n-2, memoCache);
      memoCache.put(n, result);
      System.out.println("Just cached " + n);
      return result;
    }
  }

   public int fibWithoutMemo(int n) {

    if (n == 0) return 0;
    if (n == 1) return 1;

    return fibWithoutMemo(n-1) + fibWithoutMemo(n-2);
  }

  
  public int fibWithSeparateMemoParameterFunction(int n) {
    HashMap<Integer, Integer> memo = new HashMap<>();
    return fib(n, memo);
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}