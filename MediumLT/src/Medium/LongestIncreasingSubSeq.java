package Medium;

public class LongestIncreasingSubSeq {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    for(int i=0;i<nums.length;i++) {
      dp[i] = 1;
    }

    int max=1;

    for(int i=1;i<nums.length;i++) {
      for(int j=0;j<i;j++) {
        if(nums[i]>nums[j]) {
          dp[i] = Math.max(dp[j]+1, dp[i]);
        }
      }
      max = Math.max(max, dp[i]);
    }

    return  max;
  }
}
