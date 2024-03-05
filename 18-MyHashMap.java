import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// Hash Map - Required to implement MyHashMap class, which contained generic methods ‘put(K,V)’ and ‘get(K)’ which would perform in constant time. 

public class Solution {

  @Test
  public void test() {
    MyHashMap<String, Integer> testMap = new MyHashMap<>();
    testMap.put("one", 1);
    testMap.put("two", 2);
    testMap.put("ten", 10);

    System.out.println(testMap.get("one"));
    System.out.println(testMap.get("ten"));
    System.out.println(testMap.get("five"));
  }

  public class MyHashMap<K,V> {

      private ArrayList<K> keys;
      private ArrayList<V> values;

      public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
      }

      public V get(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
          return null;
        }
        return values.get(index);
      }

      public void put(K key, V value) {
        keys.add(key);
        values.add(value);
      }
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}