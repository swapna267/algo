package Medium;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {
  public static void main(String[] args) {



  }

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    int[] charMap = new int[26];
    char[] patternArr = pattern.toCharArray();
    int[] patternSeq = new int[patternArr.length];
    for (int i=0;i<charMap.length;i++) {
      charMap[i] = -1;
    }

    for (int i=0;i<patternArr.length;i++) {
      int index = patternArr[i]-'a';
      if (charMap[index] == -1) {
        patternSeq[i] = i;
        charMap[index] = i;
      } else {
        patternSeq[i] = charMap[index];
      }
    }

    List<String> patternWords = new ArrayList<>(words.length);
    for (int i=0; i<words.length;i++) {
      for (int j=0;j<charMap.length;j++) {
        charMap[j] = -1;
      }

      char[] wordArr = words[i].toCharArray();
      int j=0;
      for (;j<wordArr.length;j++) {
        int index = wordArr[j]-'a';
        if (charMap[index] == -1) {
          charMap[index] = j;
          if (patternSeq[j] !=  j) {
            break;
          }
        } else {
          if (patternSeq[j] != charMap[index]) {
            break;
          }
        }
      }

      if (j==wordArr.length) {
        patternWords.add(words[i]);
      }
    }

    return patternWords;
  }
}
