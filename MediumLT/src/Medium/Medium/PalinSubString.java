package Medium.Medium;

public class PalinSubString {

  public static void main(String[] args) {
      System.out.println(getLongestPalinSubStr("bana"));

  }

  //aabaa a
  public static int getLongestPalinSubStr(String str) {
    char[] c = str.toCharArray();
    int globalMax = 1;

    int[][] dp = new int[c.length][c.length];
    for (int i=0;i<c.length;i++) {
      for (int j=0;j<c.length;j++) {
        if (j == i) {
          dp[i][j]=1;
        }else {
          dp[i][j] = -1;
        }
      }
    }

    for (int i=1;i<c.length;i++) {
        for (int j=0;j<i-1;j++) {
          if (dp[j+1][i-1]==1 && c[j]==c[i]) {
            dp[j][i] = 1;
            globalMax = Math.max(globalMax, i-j+1);
          }
        }
        if (c[i-1] == c[i]) {
          dp[i-1][i] = 1;
          globalMax = Math.max(globalMax, 2);
        }
    }

    return globalMax;
  }
}