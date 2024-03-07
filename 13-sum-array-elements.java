import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Sums of Consecutive Array Elements - Given an array of non-negative integers and a target integer, find the length of the shortest continuous subsequence such that the sum is greater than the target.


public class Solution {


  @Test
  public void test() {
    int[] array = {1,2,3,4,5};
    int target = 8;
    int expected = 2;
    int calculatedMinimum = caclulateMinimumLength(array, target);

    assertEquals(expected, calculatedMinimum);
  }

    @Test
  public void test2() {
    int[] array = {4,1,3,2,5};
    int target = 8;
    int expected = 3;
    int calculatedMinimum = caclulateMinimumLength(array, target);

    assertEquals(expected, calculatedMinimum);
  }

  
    @Test
  public void test3() {
    int[] array = {4,1,3,2,5,8};
    int target = 10;
    int expected = 2;
    int calculatedMinimum = caclulateMinimumLength(array, target);

    assertEquals(expected, calculatedMinimum);
  }

  
    @Test
  public void test4() {
    int[] array = {4,1,3,52,2,5};
    int target = 16;
    int expected = 1;
    int calculatedMinimum = caclulateMinimumLength(array, target);

    assertEquals(expected, calculatedMinimum);
  }

  public int caclulateMinimumLength(int[] array, int target) {

    int minLength = 0;
    for (int i = 0; i < array.length; i++) {
      int sum = 0;
      for (int j = i; j < array.length; j++) {
        sum += array[j];
        if (sum >= target) {
          int length = j - i + 1;
          if (length < minLength) {
            minLength = length;
          }
          break;
        }
      }
    }

    return minLength;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
