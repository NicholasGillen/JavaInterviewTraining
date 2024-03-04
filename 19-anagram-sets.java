import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Anagram Sets - Given a List of words, return a set of set of words where each word in an inner set is an anagram of every other word in the set. Eg - given [“cat”, “dog”, “god”, “cat”] return [[“cat”], [“dog”, “god”]].

// Got a crude solution, seems like should be more efficienct way with sorting first


public class Solution {

  // Test isn't passing, but prints the correct Sets and contents (Tried assertTrue and asertEquals)??
  @Test
  public void test1() {
    Set<String> inputSet = new HashSet<>(Arrays.asList("cat", "dog", "god", "cat"));
    Set<String> anagrams1 = new HashSet<>(Arrays.asList("cat"));
    Set<String> anagrams2 = new HashSet<>(Arrays.asList("dog", "god"));
    Set<Set<String>> expectedAnagramsSet = new HashSet<>();
    expectedAnagramsSet.add(anagrams1);
    expectedAnagramsSet.add(anagrams2);

    Set<Set<String>> calculatedAnagramsSet = calculateAnagramSets(inputSet);

    for (Set<String> set : calculatedAnagramsSet) {
      System.out.println("NEW");
      for (String word : set) {
        System.out.println(word);
      }
    }
    System.out.println("END");
    for (Set<String> set : expectedAnagramsSet) {
      System.out.println("NEW");
      for (String word : set) {
        System.out.println(word);
      }
    }

    assertEquals(calculatedAnagramsSet, expectedAnagramsSet);

  }


  public Set<Set<String>> calculateAnagramSets(Set<String> inputSet) {

    Set<Set<String>> anagramSets = new HashSet<>();
    if (inputSet.size() == 0) return anagramSets;

    for (String word : inputSet) {
      if (anagramSets.size() == 0) {
        anagramSets.add(new HashSet<String>(Arrays.asList(word)));
        continue;
      }
      boolean added = false;
      outer:
      for (Set<String> anagramSet : anagramSets) {
        for (String anagram : anagramSet) {
          //if word is anagram then add and break outer else break inner
          String[] wordLetters = word.split("");
          Arrays.sort(wordLetters);;
          String[] anagramLetters = anagram.split("");
          Arrays.sort(anagramLetters);
          if (Arrays.equals(wordLetters, anagramLetters)) {
            anagramSet.add(word);
            added = true;
            break outer;
          }
          else {
            break;
          }
        }
      }
      if (!added) {
        anagramSets.add(new HashSet<String>(Arrays.asList(word)));
      }
    }

    return anagramSets;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
