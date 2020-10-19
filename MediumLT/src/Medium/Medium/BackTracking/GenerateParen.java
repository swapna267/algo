package Medium.Medium.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParen {
  public List<String> generateParenthesis(int n) {
    return generateParenthesis(n , 0 , 0, "");
  }

  //close < open,
  public List<String> generateParenthesis(int n, int open, int close, String s) {
    List<String> possibilities = new ArrayList<>();
    if (open == n && close == n) {
      possibilities.add(s);
    }

    if (open < n) {
      possibilities.addAll(generateParenthesis(n, open+1, close, s+"("));
    }

    if (close < open && close < n) {
      possibilities.addAll(generateParenthesis(n, open, close+1, s+")"));
    }

    return possibilities;
  }

}
