package Medium;

public class MaxProduct {
  public int maxProduct(int[] nums) {
    int maxProduct = nums[0];
    int[][] dp = new int[nums.length][nums.length];

    for(int i=0;i<nums.length;i++) {
      for (int j=0;j<nums.length;j++) {
        dp[i][j] = Integer.MIN_VALUE;
      }
    }

    dp[0][0] = nums[0];

    for (int i=1;i<nums.length;i++) {
     for(int j=0;j<i;j++) {
       dp[j][i] = dp[j][i-1]*nums[i];
       maxProduct = Math.max(maxProduct, dp[j][i]);
     }
      dp[i][i] = nums[i];
      maxProduct = Math.max(maxProduct, dp[i][i]);
    }

    return maxProduct;
  }

}
