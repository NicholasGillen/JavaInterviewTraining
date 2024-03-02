import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Longest Substring - Write a function that takes a string and returns the longest substring in that string made up of the same character and the index the substring starts on, e.g. given the string “aabbbccddddaaa” the substring is “dddd” starting at index 7.

public class Solution {

  @Test
  public void basicTest() {
    String input = "aabbbccdd";
    String expected = "bbb2";
    String calulated = calculateLongestSubstring(input);

    assertEquals(expected, calulated);
  }

  @Test
  public void firstLetterIsLongest() {
    String input = "aaabbbccdd";
    String expected = "aaa0";
    String calulated = calculateLongestSubstring(input);

    assertEquals(expected, calulated);
  }

  @Test
  public void lastLetterIsLongest() {
    String input = "aabbbccddeffffff";
    String expected = "ffffff10";
    String calulated = calculateLongestSubstring(input);

    assertEquals(expected, calulated);
  }

  @Test
  public void multipleSameLength_ReturnsFirst() {
    String input = "abbccdd";
    String expected = "bb1";
    String calulated = calculateLongestSubstring(input);

    assertEquals(expected, calulated);
  }

  @Test
  public void SameLengtallh_ReturnsFirst() {
    String input = "abcd";
    String expected = "a0";
    String calulated = calculateLongestSubstring(input);

    assertEquals(expected, calulated);
  }

  public String calculateLongestSubstring(String input) {
    if (input.length() == 0) return "";
    
    int maxCount = 1;
    int currentCount = 1;
    int maxIndex = 0;
    int currentIndex = 0;
    String currentMaxLetter = input.substring(0,1);

    for (int i = 1; i < input.length(); i++) {
      String currentLetter = input.substring(i, i+1);
      if (currentLetter.equals(currentMaxLetter)) {
        currentCount++;
        if (currentCount > maxCount) {
          maxCount = currentCount;
          maxIndex = currentIndex;
        }
      }
      else {
        currentIndex = i;
        currentCount = 1;
        currentMaxLetter = currentLetter;
      }
    }

    String longestSubstring = "";
    String character = input.substring(maxIndex, maxIndex + 1);
    for (int i = 0; i < maxCount; i++) {
      longestSubstring += character;
    }

    return longestSubstring + maxIndex;
  }


  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
