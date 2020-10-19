package Medium;

/*
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 */
public class MInStepsKeyboard {
    public static void main(String[] args) {
        System.out.println(minSteps(4));
    }

    public static int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                int steps = dp[i][j] + 2;//c + p
                if (i * 2 <= n && dp[i][j]!=-1) {
                    if (dp[i + i][i] == -1 || dp[i + i][i] > steps) {
                        dp[i + i][i] = steps;
                    }
                }

                if (i + j <= n &&  dp[i][j]!=-1) {
                    steps = dp[i][j] + 1;//p
                    if (dp[i + j][j] == -1 || dp[i + j][j] > steps) {
                        dp[i + j][j] = steps;
                    }
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i<= n;i++) {
            if (dp[n][i] != -1)
                min = Math.min(dp[n][i], min);
        }

        return min;
    }
}
