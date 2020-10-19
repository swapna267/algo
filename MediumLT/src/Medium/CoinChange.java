package Medium;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    for (int i=0;i<=amount;i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    for(int i=1;i<=amount;i++) {
      for(int j=0;j<coins.length ; j++) {
        if (coins[j] > i) {
          break;
        } else if(coins[j] == i) {
          dp[i] = Math.min(dp[i], 1);
        } else {
          dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
        }
      }
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
