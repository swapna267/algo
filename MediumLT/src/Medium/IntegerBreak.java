package Medium;

public class IntegerBreak {
  class Solution {
    public int integerBreak(int n) {
      int[] dp = new int[n+1];

      for (int i=0;i<=n;i++) {
        dp[i] = 1;
      }

      for (int i=2;i<=n;i++) {
        for (int j=1;j<i;j++) {
          int product = Math.max(dp[j]*(i-j), j*(i-j));
          dp[i] = Math.max(product, dp[i]);
        }
      }
      char[] x = {};
      new String(x);

      return dp[n];


    }
  }
}
