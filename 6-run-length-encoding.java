import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Run Length Encoding - Given a string of characters return the run length encoded version. E.g. given the string “aabbbccddddaaa”, the return value would be “a2b3c2d4a3”.

public class Solution {

  @Test
  public void basicTestSingleCharacterEnd() {
    String input = "aabbcccdddeaaf";
    String expectedEncodedString = "a2b2c3d3e1a2f1";
    String calculatedEncodedString = getEncodedVersion(input);

    assertEquals(expectedEncodedString, calculatedEncodedString);
  }

  @Test
  public void basicTestMultipleCharacterEnd() {
    String input = "aabbcccdddeaafff";
    String expectedEncodedString = "a2b2c3d3e1a2f3";
    String calculatedEncodedString = getEncodedVersion(input);

    assertEquals(expectedEncodedString, calculatedEncodedString);
  }

  @Test
  public void basicTestNoMultiples() {
    String input = "abcdeaf";
    String expectedEncodedString = "a1b1c1d1e1a1f1";
    String calculatedEncodedString = getEncodedVersion(input);

    assertEquals(expectedEncodedString, calculatedEncodedString);
  }

   @Test
  public void basicTestOneCharacterOnlyMultiples() {
    String input = "aaaaa";
    String expectedEncodedString = "a5";
    String calculatedEncodedString = getEncodedVersion(input);

    assertEquals(expectedEncodedString, calculatedEncodedString);
  }

  public String getEncodedVersion(String input) {
    String encodedString = "";
    String previousLetter = input.substring(0, 1);
    int count = 1;
    for (int i = 1; i < input.length(); i++) {
      String currentLetter = input.substring(i, i+1);
      if (currentLetter.equals(previousLetter)) {
        count++;
      }
      else {
        encodedString += previousLetter + count;
        count = 1;
        previousLetter = currentLetter;
      }
    }
    encodedString += previousLetter + count;
    return encodedString;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
