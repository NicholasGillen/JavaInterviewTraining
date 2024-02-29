import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

//Letters of Alphabet - Implement a function to determine which letters of the alphabet were missing from an input string.

public class Solution {


  @Test
  public void test1() {
    String input = "abcdefghijlmnopqstuvwxy";
    String expectedMissingLetters = "krz";
    String calculatedMissingLetters = calculateMissingLetters(input);

    assertEquals(expectedMissingLetters, calculatedMissingLetters);
  }

  @Test
  public void test2() {
  String input = "xyz";
  String expectedMissingLetters = "abcdefghijklmnopqrstuvw";
  String calculatedMissingLetters = calculateMissingLetters(input);

  assertEquals(expectedMissingLetters, calculatedMissingLetters);
  }

  @Test
  public void test3() {
  String input = "abcdf";
  String expectedMissingLetters = "eghijklmnopqrstuvwxyz";
  String calculatedMissingLetters = calculateMissingLetters(input);

  assertEquals(expectedMissingLetters, calculatedMissingLetters);
  }

  public String calculateMissingLetters(String input) {

    String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    String[] alphabetLetters = alphabetString.split("");
    Set<String> lettersSet = new HashSet<>();
    for (int i = 0; i < alphabetLetters.length; i++) {
      lettersSet.add(alphabetLetters[i]);
    }
    for (int i = 0; i < input.length(); i++) {
      lettersSet.remove(input.substring(i, i+1));
    }

    String missingLetters = "";

    Iterator<String> lettersIterator = lettersSet.iterator();
    while(lettersIterator.hasNext()) {
      missingLetters += lettersIterator.next();
    }
    System.out.println(missingLetters);
    return missingLetters;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
