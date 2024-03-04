import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Prime Countdown Generator - Use a generator function to yield the primes down from n. E.g. function* countdownPrimes (n) Further points for tests and outputing the results as a single array afterwards.

public class Solution {

  @Test
  public void test1() {
    int n = 15;
    int[] expectedPrimes = {13,11,7,5,3,2};
    int[] calculatedPrimes = generatePrimes(n);

    assertArrayEquals(expectedPrimes, calculatedPrimes);
  }

  @Test
  public void boundaryTest1() {
    int n = 1;
    int[] expectedPrimes = {};
    int[] calculatedPrimes = generatePrimes(n);

    assertArrayEquals(expectedPrimes, calculatedPrimes);
  }

  @Test
  public void boundaryTest2() {
    int n = 2;
    int[] expectedPrimes = {2};
    int[] calculatedPrimes = generatePrimes(n);

    assertArrayEquals(expectedPrimes, calculatedPrimes);
  }
  
  @Test
  public void nIsAlsoPrime() {
    int n = 13;
    int[] expectedPrimes = {13,11,7,5,3,2};
    int[] calculatedPrimes = generatePrimes(n);

    assertArrayEquals(expectedPrimes, calculatedPrimes);
  }
  

  public int[] generatePrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    while (n >= 2) {
      if (isPrime(n)) {
        primes.add(n);
      }
      n--;
    }

    return primes.stream().mapToInt(i -> i).toArray();
  }

   private boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
      for (int i = 2; i < n; i++) {
        if (n % i == 0) {
          return false;
        }
      }
      return true;
    }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}