import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

//Pair Summing - Write a function that counts how many pairs of numbers in an array add up to a given number. Additional question was how to do this more efficiently.


public class Solution {

  @Test
  public void addTo10() {
    int[] array = {5,4,5,6,7,2};
    int expectedPairsCount = 2;
    int calculatedPairCount = calculatePairs(array, 10);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  @Test
  public void addTo4() {
    int[] array = {1,3,5,6,7,2,2,0,4};
    int expectedPairsCount = 3;
    int calculatedPairCount = calculatePairs(array, 4);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  @Test
  public void addTo9() {
    int[] array = {1,3,5,6,7,2,2,0,4,8,8,8};
    int expectedPairsCount = 7;
    int calculatedPairCount = calculatePairs(array, 9);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  @Test
  public void noPairs() {
    int[] array = {5,4,1,3,75,12,8};
    int expectedPairsCount = 0;
    int calculatedPairCount = calculatePairs(array, 10);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  @Test
  public void allPairs() {
    int[] array = {5,5,5,5};
    int expectedPairsCount = 6;
    int calculatedPairCount = calculatePairs(array, 10);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  @Test
  public void heavyRightSidedArray() {
    int[] array = {8,8,2,2,8,8,8,8,8};
    int expectedPairsCount = 14;
    int calculatedPairCount = calculatePairs(array, 10);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  @Test
  public void heavyLeftSidedArray() {
    int[] array = {9,1,1,1,1,9,1,1,1};
    int expectedPairsCount = 14;
    int calculatedPairCount = calculatePairs(array, 10);

    assertEquals(expectedPairsCount, calculatedPairCount);
  }

  public int calculatePairs(int[] array, int givenNumber) {
    Arrays.sort(array);
    int count = 0;
    for (int i = 0; i < array.length-1; i++) {
      int currentNumber = array[i];
      if (currentNumber >= (givenNumber/2) + 1) {
        break;
      }
      for (int j = i+1; j < array.length; j++) {
        int currentCheck = array[j];
        if (currentNumber + currentCheck == givenNumber) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}

