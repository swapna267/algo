package Medium;/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
*/


// numtrees -> 1,2,3,4,5 .. 1 as root and
// to calculate dp[n] use dp[n-1] n > n-1 , so n has to be added as rt child
// dp[n][n] -> n+1 (1,2,3... n+1) with n as depth of rt tree.
//    RT Depth here is number of nodes from root excluding root to rtmost only traversing through the rt subchilds
// dp[n][n] = 1 because if we have n+1 nodes , addig all of them to the right is the only option

// dp[n][0] = adding n as root to all trees with n-1 nodes. dp[n-1][0]+....dp[n-1][j] j<n
// dp[n][1] = dp[n-1][0]+dp[n-1][1]..dp[n-1][j] j<n
// dp[n][2] = dp[n-1][1]..dp[n-1][j] j<n
// dp[n][3] = dp[n-1][2]..dp[n-1][j] j<n
// So dp[n][2] = dp[n][3] + dp[n-1][1] => dp[n][j] = dp[n][j+1] + dp[n][j]

public class UniqueBST {
    public int getUniqueBst(int n) {
      if (n == 0) {
        return 0;
      }

      int[][] dp = new int[n][n];
      for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++) {
          dp[i][j] = 0;
        }
      }

      dp[0][0] = 1;

      for (int i=1; i<n; i++) {
        dp[i][i] = 1;
        for (int j=i-1;j>0;j--) {
          dp[i][j] = dp[i][j+1] + dp[i-1][j-1];
        }
        dp[i][0] = dp[i][1];
      }

      int tot = 0;
      for (int i=0;i<n;i++) {
        tot += dp[n-1][i];
      }
      return tot;
    }
}
