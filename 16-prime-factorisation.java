import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Prime Factorisation - Factorise a given number, expressing the result as an int[] of primes. e.g. 6 = [2,3] and 12 = [2,2,3]

public class Solution {

  @Test
  public void test1() {
    int[] calculated = calculatePrimeFactors(18);
    int[] expected = {2,3,3};

    assertArrayEquals(expected, calculated);
  }

   @Test
  public void test2() {
    int[] calculated = calculatePrimeFactors(8);
    int[] expected = {2,2,2};

    assertArrayEquals(expected, calculated);
  }

   @Test
  public void test3() {
    int[] calculated = calculatePrimeFactors(25);
    int[] expected = {5,5};

    assertArrayEquals(expected, calculated);
  }

   @Test
  public void noFactors() {
    int[] calculated = calculatePrimeFactors(19);
    int[] expected = {};

    assertArrayEquals(expected, calculated);
  }

  public int[] calculatePrimeFactors(int number) {
    if (number < 2) {
      return new int[]{};
    }

    ArrayList<Integer> possiblePrimes = new ArrayList<>();
    possiblePrimes.add(2);
    outer:
    for (int i = 3; i <= number/2; i++) {
      for (int j = 2; j <= i/2; j++) {
        if (i % j == 0) {
          continue outer;
        }
      }
      possiblePrimes.add(i);
    }

    int i = 0;
    int currentVal = number;
    ArrayList<Integer> factors = new ArrayList<>();
    while (true) {
      if (currentVal == 1) {
        break;
      }
      if (currentVal % possiblePrimes.get(i) == 0) {
        factors.add(possiblePrimes.get(i));
        currentVal = currentVal / possiblePrimes.get(i);
      }
      else {
        i++;
        if (i == possiblePrimes.size()) break;
      }
    }

    return factors.stream().mapToInt(num -> num).toArray();
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
