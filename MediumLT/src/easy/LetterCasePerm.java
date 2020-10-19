package easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePerm {
  public List<String> letterCasePermutation(char[] chars, int index, String s) {
    List<String> list = new ArrayList<>();

    if (index == chars.length) {
      list.add(s);
      return list;
    }

    if (chars[index] >= 'a' && chars[index] <= 'z') {
      char c = (char) (chars[index]-32);
      list.addAll(letterCasePermutation(chars, index+1, s+c));
    }

    if (chars[index] >= 'A' && chars[index] <= 'Z') {
      char c = (char) (chars[index]+32);
      list.addAll(letterCasePermutation(chars, index+1, s+c));
    }


    list.addAll(letterCasePermutation(chars, index+1, s+chars[index]));
    return list;
  }
}
