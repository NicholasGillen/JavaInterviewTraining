import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Kids in a Circle - Harder Solution
// Write a method taking (n, k) where you have k kids in a circle and a phrase of length n words (Eeny, meeny, miny, moe). Count round your kids, remove the one you land on from the list, and continue. Output the kid that will be left.

// Counting carries on from the NEXT kid after a kid has been eliminated, doesn't reset from kid 1
public class Solution {

  @Test
  public void kidsLessThanWords() {
    int numKids = 3;
    int numWords = 5;

    int expectedKidRemaining = 1;
    int calculatedKidRemaining = findRemainingKid(numWords, numKids);

    assertEquals(expectedKidRemaining, calculatedKidRemaining);
  }

   @Test
  public void kidsMoreThanWords() {
    int numKids = 3;
    int numWords = 2;

    int expectedKidRemaining = 3;
    int calculatedKidRemaining = findRemainingKid(numWords, numKids);

    assertEquals(expectedKidRemaining, calculatedKidRemaining);
  }

    @Test
  public void kidsMoreThanWords2() {
    int numKids = 7;
    int numWords = 2;

    int expectedKidRemaining = 7;
    int calculatedKidRemaining = findRemainingKid(numWords, numKids);

    assertEquals(expectedKidRemaining, calculatedKidRemaining);
  }

  
    @Test
  public void numWordsMultipleOfNumKids() {
    int numKids = 3;
    int numWords = 6;

    int expectedKidRemaining = 1;
    int calculatedKidRemaining = findRemainingKid(numWords, numKids);

    assertEquals(expectedKidRemaining, calculatedKidRemaining);
  }

      @Test
  public void kidsMoreThanWords3() {
    int numKids = 7;
    int numWords = 5;

    int expectedKidRemaining = 6;
    int calculatedKidRemaining = findRemainingKid(numWords, numKids);

    assertEquals(expectedKidRemaining, calculatedKidRemaining);
  }

  public int findRemainingKid(int n, int k) {
    int[] kidsArray = new int[k];
    for (int i = 0; i < k; i++) {
      kidsArray[i] = i+1;
    }
    while (kidsArray.length > 1) {
      System.out.println("current array is: ");
      for (int i : kidsArray) System.out.println(i);
      int removalIndex = -1;
      if (n < kidsArray.length) {
        removalIndex = n-1;
      }
      else if (n % kidsArray.length == 0) {
        removalIndex = kidsArray.length - 1;
      }
      else {
        removalIndex = (n % kidsArray.length) - 1;
      }
      System.out.println("removal index is " + removalIndex);
      int[] newKidsArray = new int[kidsArray.length - 1];
      int j = 0;
        for (int i = removalIndex; i < kidsArray.length; i++) {
        if (i != removalIndex) {
          newKidsArray[j] = kidsArray[i];
          j++;
        }
      }
        for (int i = 0; i < removalIndex; i++) {
          newKidsArray[j] = kidsArray[i];
          j++;
      }
      kidsArray = newKidsArray;
      System.out.println("current array is");
      for (int i : kidsArray) System.out.println(i);
    }
    return kidsArray[0];
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}