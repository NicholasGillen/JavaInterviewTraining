import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Median of Two Arrays - Given two sorted int arrays find the median element.


public class Solution {

  @Test
  public void oddTotalNumberElements() {
    int[] array1 = {1,2,4,10};
    int[] array2 = {2,3,5,7,18};

    int expectedMedianValue = 4;
    int calculatedMedianValue = getMedian(array1, array2);
    
    assertEquals(expectedMedianValue, calculatedMedianValue);
  }

  @Test
  public void evenTotalNumberElements() {
    int[] array1 = {1,2,4,10,11};
    int[] array2 = {2,3,6,7,20};

    int expectedMedianValue = 5;
    int calculatedMedianValue = getMedian(array1, array2);
    
    assertEquals(expectedMedianValue, calculatedMedianValue);
  }

  public int getMedian(int[] array1, int[] array2) {

    int totalElements = array1.length + array2.length;
    if (totalElements % 2 == 0) {
      int medianIndex = (totalElements / 2) - 1;
      int count = 0;
      int array1Index = 0;
      int array2Index = 0;
      while (count < medianIndex) {
        if (array1[array1Index] <= array2[array2Index]) {
          array1Index++;
        }
        else {
          array2Index++;
        }
        count++;
      }
      int medianVal1 = 0;
      int medianVal2 = 0;
      if (array1[array1Index] <= array2[array2Index]) {
          medianVal1 = array1[array1Index];
          array1Index++;
        }
        else {
          medianVal1 = array2[array2Index];
          array2Index++;
        }
          if (array1[array1Index] <= array2[array2Index]) {
          medianVal2 = array1[array1Index];
        }
        else {
          medianVal2 = array2[array2Index];
        }
        return (medianVal1 + medianVal2) / 2;
    }
    else {
      int medianIndex = ((totalElements + 1) / 2) - 1;
      int count = 0;
      int array1Index = 0;
      int array2Index = 0;
      while (count <= medianIndex) {
        if (array1[array1Index] <= array2[array2Index]) {
          if (count == medianIndex) {
            return array1[array1Index];
          }
          array1Index++;
        }
        else {
            if (count == medianIndex) {
            return array2[array2Index];
          }
          array2Index++;
        }
        count++;
      }
        // if (array1[array1Index] <= array2[array2Index]) {
        //   return array1[array1Index];
        // }
        // else {
        //   return array2[array2Index];
        // }
    }

    return 0;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
