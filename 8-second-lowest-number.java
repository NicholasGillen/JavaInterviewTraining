import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Second Lowest Number - Write a function that takes an array of numbers and returns the second lowest number in the array, or zero if the length of the array is less than two.


public class Solution {

  @Test
  public void test1() {
    int[] array = {1,5,6,2,4,3,8,9};
    int expected = 2;
    int calculated = getSecondLowest(array);

    assertEquals(expected, calculated);
  }

  @Test
  public void twoNumbers() {
    int[] array = {33,19};
    int expected = 33;
    int calculated = getSecondLowest(array);

    assertEquals(expected, calculated);
  }

  @Test
  public void lastNumberIsSecondLowest() {
    int[] array = {10,5,6,4,1,8,9,3};
    int expected = 3;
    int calculated = getSecondLowest(array);

    assertEquals(expected, calculated);
  }

     @Test
  public void firstNumberIsSecondLowest() {
    int[] array = {2,5,6,4,1,8,9,3};
    int expected = 2;
    int calculated = getSecondLowest(array);

    assertEquals(expected, calculated);
  }

  public int getSecondLowest(int[] array) {

    if (array.length < 2) return 0;

    int lowest = 0;
    int secondLowest = 0;

    if (array[0] <= array[1]) {
      lowest = array[0];
      secondLowest = array[1];
    }
    else {
      lowest = array[1];
      secondLowest = array[0];
    }

    for (int i = 2; i < array.length; i++) {
      int currentVal = array[i];
      if (currentVal < lowest) {
        secondLowest = lowest;
        lowest = currentVal;
      }
      else if (currentVal < secondLowest) {
        secondLowest = currentVal;
      }
    }

    return secondLowest;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
