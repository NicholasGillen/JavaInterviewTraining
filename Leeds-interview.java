import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Longest substring with unique charcters - Given a string, write a method to find the length of the longest substring without duplicate characters.

public class Solution {

  @Test
  public void test1() {
  String input = "abcdeff";
  String expected = "abcdef";

  assertEquals(expected, getMinimumSequence(input));
  }

  @Test
  public void test2() {
  String input = "abaccdefg";
  String expected = "cdefg";

  assertEquals(expected, getMinimumSequence(input));
  }
  
  @Test
  public void test3() {
  String input = "abcdaefgghijklmnk";
  String expected = "ghijklmn";

  assertEquals(expected, getMinimumSequence(input));
  }

  @Test
  public void test4() {
  String input = "heh";
  String expected = "he";

  assertEquals(expected, getMinimumSequence(input));
  }

  @Test
  public void allLettersUnique() {
  String input = "abcdefghijklmnop";
  String expected = "abcdefghijklmnop";

  assertEquals(expected, getMinimumSequence(input));
  }

  @Test
  public void sameRepeatedLetter() {
  String input = "hhhhhh";
  String expected = "h";

  assertEquals(expected, getMinimumSequence(input));
  }


  public String getMinimumSequence(String input) {
    if (input.length() == 0) {
      return "";
    }

    Map<Character, Integer> characterFrequency = new HashMap<>();
    int i = 0;
    String maxString = "";
    int currentStartIndex = 0;
    while (i < input.length()) {
      char currentLetter = input.charAt(i);
      if (!characterFrequency.containsKey(currentLetter)) {
        characterFrequency.put(currentLetter, i);
        i++;
      }
      else {
        int currentLength = i - currentStartIndex;
        if (currentLength > maxString.length()) {
          maxString = input.substring(currentStartIndex, i);
        }
        currentStartIndex = characterFrequency.get(currentLetter) + 1;
        i = currentStartIndex;
        characterFrequency.clear();
      }
    }
    // Account for final letter
    int currentLength = input.length() - currentStartIndex;
    if (currentLength > maxString.length()) {
          maxString = input.substring(currentStartIndex);
        }

    return maxString;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}