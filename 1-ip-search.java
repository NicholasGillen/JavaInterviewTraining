import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;


public class Solution {

  @Test
  public void first_entry() {
    String[] input = {
          "10.0.0.1 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "10.0.0.4 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "10.0.0.3 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "10.0.0.1 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        };

        String expected = "10.0.0.1";
        String actual = getMostCommonIp(input);

        assertThat(actual, equalTo(expected));
  }

  @Test
  public void second_entry() {
      String[] input = {
        "10.0.0.1 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "10.0.0.4 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "10.0.0.3 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "10.0.0.4 – username Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
      };

      String expected = "10.0.0.4";
      String actual = getMostCommonIp(input);

      assertThat(actual, equalTo(expected));
  }

  public String getMostCommonIp(String[] input) {
    int maxCount = 0;
    String mostFrequentIp = "";

    Map<String, Integer> ipAndCount = new HashMap<>();

    for (String line : input) {
      String ipAddress = line.split(" ")[0];
      int newCount;
      if (!ipAndCount.containsKey(ipAddress)) {
        newCount = 1;
      }
      else {
        int currentCount = ipAndCount.get(ipAddress);
        newCount = currentCount + 1;
      }
      ipAndCount.put(ipAddress, newCount);
      if (newCount > maxCount) {
        maxCount = newCount;
        mostFrequentIp = ipAddress;
      }
    }
    return mostFrequentIp;
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
