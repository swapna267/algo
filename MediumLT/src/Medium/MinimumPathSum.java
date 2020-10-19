package Medium;

/*
* Given a m x n grid filled with non-negative numbers,
* find a path from top left to bottom right which minimizes the sum of all numbers along its path.
* */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] solns = new int[rows][cols];
        for (int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                solns[i][j] = -1;
            }
        }

       return minPathSum(grid, rows-1, cols-1, solns);
    }

    public static int minPathSum(int[][] grid, int endRowIndex, int endColIndex, int[][] solns) {
        if (endRowIndex == 0 && endColIndex == 0){
            return grid[0][0];
        }

        int minCost = -1;
        if (endRowIndex > 0) {
            if (solns[endRowIndex-1][endColIndex] == -1) {
                solns[endRowIndex-1][endColIndex] = minPathSum(grid, endRowIndex-1, endColIndex, solns);
            }
            minCost = solns[endRowIndex-1][endColIndex];
        }

        if (endColIndex > 0) {
            if(solns[endRowIndex][endColIndex-1] == -1) {
                solns[endRowIndex][endColIndex-1] = minPathSum(grid, endRowIndex, endColIndex-1, solns);
            }
            if (minCost == -1 || solns[endRowIndex][endColIndex-1] < minCost) {
                minCost = solns[endRowIndex][endColIndex-1];
            }
        }

        return minCost + grid[endRowIndex][endColIndex];
    }
}
