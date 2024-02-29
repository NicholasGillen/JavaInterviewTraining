import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;

//Single character search - Take an input of a string and find the first character which only appears once in the string.

public class Solution {

  @Test
  public void firstLetterIsFirstUnique() {
      
      String input = "hello";

      String expected = "h";
      String actual = getFirstUniqueCharacter(input);

      assertThat(actual, equalTo(expected));
  }

  @Test
  public void secondLetterIsFirstUnique() {
      
      String input = "helhlo";

      String expected = "e";
      String actual = getFirstUniqueCharacter(input);

      assertThat(actual, equalTo(expected));
  }

  @Test
  public void lastLetterIsFirstUnique() {
      
      String input = "hhehhlleo";

      String expected = "o";
      String actual = getFirstUniqueCharacter(input);

      assertThat(actual, equalTo(expected));
  }

  @Test
  public void noUniqueCharacters() {
      
      String input = "hellhoeo";

      String expected = "";
      String actual = getFirstUniqueCharacter(input);

      assertThat(actual, equalTo(expected));
  }

  public String getFirstUniqueCharacter(String input) {
    Set<String> usedLetters = new HashSet<>();
    for (int i = 0; i < input.length(); i++) {
      boolean unique = true;
      String currentLetter = input.substring(i, i+1);
      if (usedLetters.contains(currentLetter)) {
        continue;
      }
      for (int j = i+1; j < input.length(); j++) {
        String letterToCompare = input.substring(j, j+1);
        if (currentLetter.equals(letterToCompare)) {
          usedLetters.add(currentLetter);
          unique = false;
          break;
        }
      }
      if (unique == true) {
        return currentLetter;
      }
    }
    return "";
  }


  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
