package Medium.Medium.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombs {
  public List<String> letterCombinations(String digits) {

    return letterCombinations(digits.toCharArray(), 0, "");
  }

  public List<String> letterCombinations(char[] digits, int index, String s) {
      List<String> combs = new ArrayList<>();
      if (index == digits.length) {
        combs.add(s);
        return combs;
      }

      int digit = Character.digit(digits[index], 10);
    combs.addAll(letterCombinations(digits, index+1, s+('a'+((digit-1)*3))));
    combs.addAll(letterCombinations(digits, index+1, s+('a'+((digit-1)*3+1))));
    combs.addAll(letterCombinations(digits, index+1, s+('a'+((digit-1)*3+2))));
    return combs;
  }
}
