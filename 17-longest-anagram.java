import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Longest Anagram from Dictionary - Given an array of words, find all the longest anagrams of the supplied letters. E.g. Dictionary = [“toe”, “toes”, “got”, “toga”, “other”], letters_1 = “otge”, result_1 = [“toe”, “got”],  letters_2 = “otes”, result_2 = [“toes”]. The question also says that performance is important - that the dictionary contains 100,000 words.

// Currently returns all possible anagrams - need to amend to only return largest anagrams

public class Solution {

  @Test
  public void basicTest() {
    String[] dictionary = {"toe", "toes", "got", "toga", "other"};
    String letters = "otge";
    String[] expected = {"toe", "got"};

    findAnagrams(dictionary, letters);

  }

  @Test
  public void basicTest2() {
    String[] dictionary = {"toe", "toes", "got", "toga", "other"};
    String letters = "otes";
    String[] expected = {"toes"};

    findAnagrams(dictionary, letters);

  }

  public String[] findAnagrams(String[] dictionary, String letters) {

    //  char[] characters = letters.toCharArray();
    //   Arrays.sort(characters);
    //   St=String.valueOf(characters);

    List<String> anagrams = new ArrayList<>();

    Arrays.sort(dictionary, new Comparator<String>() {
      public int compare(String a, String b) {
        return a.length() - b.length();
      }
    });

    // Create map of number of times letters appear in the supplied word
    Map<Character, Integer> letterCount = new HashMap<>();
    for (int i = 0; i < letters.length(); i++) {
      char currentLetter = letters.charAt(i);
      if (!letterCount.containsKey(currentLetter)) {
        letterCount.put(currentLetter, 1);
      }
      else {
        int currentCount = letterCount.get(currentLetter);
        currentCount++;
        letterCount.put(currentLetter, currentCount);
      }
    }

    outer:
    for (int i = 0; i < dictionary.length; i++) {
      String word = dictionary[i];
      if (word.length() > letters.length()) {
        break;
      }
      char[] wordLetters = word.toCharArray();
      Arrays.sort(wordLetters);
      
      int currentLetterCount = 1;
      char previousLetter = wordLetters[0];
      for (int j = 1; j < wordLetters.length; j++) {
        char letter = wordLetters[j];
        if (letter == previousLetter) {
          currentLetterCount++;
        }
        else {
          if (letterCount.get(previousLetter) != null) {
          int numLettersInMap = letterCount.get(previousLetter);
          if (numLettersInMap < currentLetterCount) {
            continue outer;
          }
          currentLetterCount = 1;
          previousLetter = letter;
          }
        }
      }
      if (letterCount.get(previousLetter) != null) {
      int numLettersInMap = letterCount.get(previousLetter);
      if (numLettersInMap >= currentLetterCount) {
        anagrams.add(word);
      }
      }
    }

  for (String word : anagrams) {
    System.out.println(word);
  }


    return null;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}