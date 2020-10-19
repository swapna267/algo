package Medium.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import java.util.concurrent.LinkedBlockingQueue;

public class LetterCombs {

  public static void main(String[] args) {
    char[][] mappings = new char[9][];
    mappings[0] = "one".toCharArray();


  }

  public List<String> letterCombinations(String digits) {

    char[] digitsChars = digits.toCharArray();

    if(digitsChars.length == 0) {
      return Collections.emptyList();
    }

    List<String> list = new LinkedList<>();
    for (char c:getMapping(digitsChars[0])) {
      list.add(Character.toString(c));
    }

    int lastAdded = 3;

    for (int i=1;i<digitsChars.length;i++) {
      int addedTo = 0;

      while(addedTo < lastAdded) {
        String in = list.remove(0);
        for (char c:getMapping(digitsChars[i])) {
          list.add(in+Character.toString(c));
        }
        addedTo++;
      }
      lastAdded = list.size();
    }

    return list;
  }

  public static char[] getMapping(char c) {
    if (c == '2') {
      return new char[]{'a','b','c'};
    }

    if (c == '3') {
      return new char[]{'d','e','f'};
    }

    if (c == '4') {
      return new char[]{'g','h','i'};
    }
    if (c == '5') {
      return new char[]{'j','k','l'};
    }
    if (c == '6') {
      return new char[]{'m','n','o'};
    }
    if (c == '7') {
      return new char[]{'p','q','r','s'};
    }
    if (c == '8') {
      return new char[]{'t','u','v'};
    }
    if (c == '9') {
      return new char[]{'w','x','y','z'};
    }

    return new char[]{};
  }
}
