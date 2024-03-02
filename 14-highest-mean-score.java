import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Student Scores As Nested Array: Find Highest Mean Score - Given an array of length-2 String arrays, with each length-2 array containing a student’s name and a string representation of a integral examination score, find the highest mean score across all students.  Different students could have sat different numbers of exams; exam scores can be negative; no need to return the name of the student who did best, just the score; if there are no students at all, return zero; if the mean for a student is not an integer, then use the highest integer that is lower than the exact mean (tip, not part of the question: be careful about assuming this can be done with integer division).  Question had a single, simple test case; I was required to write more.  Initial test case was something like : {{“Charles”, “50”}, {“Barry”, “67”}, {“Charles”, “80”}, {“John”, “49”}}.  The result should be 67, because that is the highest mean score across all students. 

public class Solution {

  @Test
  public void basicTest() {
    String[][] scores = {
      {"a", "10"}, {"b", "6"}, {"a", "5"}
    };

    int expectedHighestMeanScore = 7;
    int calculatedHighestMeanScore = calculateHighestMeanScore(scores);
    
    assertEquals(expectedHighestMeanScore, calculatedHighestMeanScore);
  }

  @Test
  public void basicTestWithNegativeValues() {
    String[][] scores = {
      {"a", "10"}, {"b", "6"}, {"a", "5"}, {"a", "-20"}
    };

    int expectedHighestMeanScore = 6;
    int calculatedHighestMeanScore = calculateHighestMeanScore(scores);
    
    assertEquals(expectedHighestMeanScore, calculatedHighestMeanScore);
  }

    @Test
  public void basicTestLastStudentIsHighest() {
    String[][] scores = {
      {"a", "10"}, {"b", "6"}, {"a", "5"}, {"c", "9"} , {"b", "2"}, {"c", "8"}
    };

    int expectedHighestMeanScore = 8;
    int calculatedHighestMeanScore = calculateHighestMeanScore(scores);
    
    assertEquals(expectedHighestMeanScore, calculatedHighestMeanScore);
  }

  public int calculateHighestMeanScore(String[][] scores) {
    if (scores.length == 0) return 0;

    Map<String, int[]> collatedScores = new HashMap<>();
    for (int i = 0; i < scores.length; i++) {
      String currentStudent = scores[i][0];
      int currentScoreAsInteger = Integer.parseInt(scores[i][1]);
      if (collatedScores.containsKey(currentStudent)) {
        int[] currentStudentScoreData = collatedScores.get(currentStudent);
        int currentStudentTotalScore = currentStudentScoreData[0];
        int currentStudentNumberExamsTaken = currentStudentScoreData[1];

        currentStudentTotalScore += currentScoreAsInteger;
        currentStudentNumberExamsTaken++;
        collatedScores.put(currentStudent, new int[]{currentStudentTotalScore, currentStudentNumberExamsTaken});
      }
      else {
        collatedScores.put(currentStudent, new int[]{currentScoreAsInteger, 1});
      }
    }
    int highestMeanScore = 0;
    for (int[] studentData : collatedScores.values()) {
      int meanScore = studentData[0] / studentData[1];
      if (meanScore > highestMeanScore) {
        highestMeanScore = meanScore;
      }
    }
    return highestMeanScore;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
