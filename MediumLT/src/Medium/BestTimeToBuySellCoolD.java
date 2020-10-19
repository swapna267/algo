package Medium;

public class BestTimeToBuySellCoolD {

    public int maxProfit(int[] prices) {
      int[] dp = new int[prices.length];
      int len = prices.length;

      if(len==0) {
        return 0;
      }

      for(int i=0;i<len;i++) {
        for (int j=i-1;j>=0;j--) {
          int profit = 0;
          if(prices[i] > prices[j]) {
            profit += prices[i]-prices[j];
            if (j-2>=0) {
              profit += dp[j-2];
            }
          }

          profit = Math.max(dp[j],profit);
          dp[i] = Math.max(dp[i],profit);
        }
      }
      return dp[len-1];
    }

}
