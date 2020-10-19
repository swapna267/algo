package Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> dict =  new HashSet<>();
      for (String word: wordDict) {
        dict.add(word);
      }

      int[] dp = new int[s.length()];
      for (int i=0; i<s.length();i++) {
        dp[i] = 0;
      }
      for (int i=0; i<s.length(); i++) {
        for (int j=0;j<i;j++) {
          //j=0.. dp[j] && substring(j+1,i)
          if (dp[j]==1 && dict.contains(s.substring(j+1,i+1))) {
            dp[i] = 1;
            break;
          }
        }
        if (dp[i]==0 && dict.contains(s.substring(0,i+1))) {
          dp[i] = 1;
        }
      }

      if (dp[s.length()-1] == 1) {
        return true;
      }
      return false;
  }
}
