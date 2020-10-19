package Medium;

/*
Given an integer array with all positive numbers and no duplicates,
find the number of possible combinations that add up to a positive integer target.
 */
public class combinationsum4 {
  public int combinationSum4(int[] nums, int target) {
      int[] dp = new int[target+1];
      for (int i=0;i<=target;i++) {
        dp[i] = 0;
      }

      for(int sum=1;sum<=target;sum++) {
        for(int j=0;j<nums.length;j++) {
          if(sum == nums[j]) {
            dp[sum]=dp[sum]+1;
          }

          if (sum < nums[j]) {
            dp[sum]= dp[sum]+dp[sum-nums[j]];
          }
        }
      }

      return dp[target];
  }
}
