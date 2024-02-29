import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

// Powers of 10 - Given a number x, write a function to determine if this is a power of 10. 

public class Solution {

  @Test
  public void nonMultipleOfTenBelowTen() {
    int testValue = 7;
    boolean result = isPowerOfTen(testValue);
    boolean expected = false;

    assertEquals(expected, result);
  }

    @Test
    public void nonMultipleOfTenAboveTen() {
    int testValue = 57;
    boolean result = isPowerOfTen(testValue);
    boolean expected = false;

    assertEquals(expected, result);
  }

    @Test
    public void largeNonMultipleOfTenAboveTen() {
    int testValue = 55699;
    boolean result = isPowerOfTen(testValue);
    boolean expected = false;

    assertEquals(expected, result);
  }

    @Test
    public void multipleOfTen() {
    int testValue = 760;
    boolean result = isPowerOfTen(testValue);
    boolean expected = false;

    assertEquals(expected, result);
  }

    @Test
    public void largeMultipleOfTen() {
    int testValue = 760090;
    boolean result = isPowerOfTen(testValue);
    boolean expected = false;

    assertEquals(expected, result);
  }

    @Test
    public void powerOfTen() {
    int testValue = 100;
    boolean result = isPowerOfTen(testValue);
    boolean expected = true;

    assertEquals(expected, result);
  }

    @Test
    public void largePowerOfTen() {
    int testValue = 100000;
    boolean result = isPowerOfTen(testValue);
    boolean expected = true;

    assertEquals(expected, result);
  }

    @Test
    public void exactlyTen() {
    int testValue = 10;
    boolean result = isPowerOfTen(testValue);
    boolean expected = true;

    assertEquals(expected, result);
  }

    @Test
    public void exactylOne() {
    int testValue = 1;
    boolean result = isPowerOfTen(testValue);
    boolean expected = true;

    assertEquals(expected, result);
  }

  public boolean isPowerOfTen(int x) {
    if (x == 1) {
      return true;
    }
    if (x % 10 != 0) {
      return false;
    }
    int val = x / 10;
    if (val >= 10) {
      return isPowerOfTen(val);
    }
    else {
      return val == 1;
    }
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
