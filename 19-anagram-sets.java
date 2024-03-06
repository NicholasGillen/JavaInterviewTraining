import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// //Anagram Sets
// Given a List of words, return a set of set of words where each word in an inner set is an anagram of every other word in the set.
// Eg - given [“cat”, “dog”, “god”, “cat”] return [[“cat”], [“dog”, “god”]].


public class Solution {

  @Test
  public void test() {
    List<String> words = new ArrayList<>(Arrays.asList("cat", "god", "dog", "pig", "god", "cat", "act", 
    "good", "tac"));

    Set<String> anagrams1 = new HashSet<>(Arrays.asList("cat", "act", "tac"));
     Set<String> anagrams2 = new HashSet<>(Arrays.asList("god", "dog"));
      Set<String> anagrams3 = new HashSet<>(Arrays.asList("pig"));
       Set<String> anagrams4 = new HashSet<>(Arrays.asList("good"));
    Set<Set<String>> anagramsSet = new HashSet<>();
    anagramsSet.add(anagrams1);
    anagramsSet.add(anagrams2);
    anagramsSet.add(anagrams3);
    anagramsSet.add(anagrams4);
    
    Set<Set<String>> calculatedAnagrams = getAnagrams(words);

    if (anagramsSet.containsAll(calculatedAnagrams) && calculatedAnagrams.containsAll(anagramsSet)) {
      System.out.println("TRUE");
    }
  }

  public Set<Set<String>> getAnagrams(List<String> words) {
    HashMap<String, Set<String>> map = new HashMap<>();
    for (String word : words) {
      char[] letters = word.toCharArray();
      Arrays.sort(letters);
      String sorted = String.valueOf(letters);

      if (map.containsKey(sorted)) {
        map.get(sorted).add(word);
      }
      else {
        Set<String> set = new HashSet<>();
        set.add(word);
        map.put(sorted, set);
      }
    }
    Set<Set<String>> anagrams = new HashSet<>();
    for (Set<String> set : map.values()) {
      anagrams.add(set);
    }
    return anagrams;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}