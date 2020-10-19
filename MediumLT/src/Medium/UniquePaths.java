package Medium;/*
* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
* */


public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(2,2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] solns = new int[m+1][n+1];
        for (int i=0;i<=m;i++) {
            for (int j=0;j<=n;j++) {
                solns[i][j] = -1;
            }
        }
        return uniquePaths(m, n, solns);
    }

    public static int uniquePaths(int m, int n,int[][] solns) {
        if(m<1 || n<1) return 0;

        if(m==1 && n==1) {
            return 1;
        }

        if (solns[m-1][n] == -1) {
            solns[m-1][n] = uniquePaths(m-1, n, solns);
        }

        if (solns[m][n-1] == -1) {
            solns[m][n-1] = uniquePaths(m, n-1, solns);
        }

        return solns[m-1][n] + solns[m][n-1];
    }

}
