package Medium;

/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*/
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] grid  = new int[1][2];
        grid[0][0] = 0;
        grid[0][1] = 0;
        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int cols = obstacleGrid[0].length;
        int rows = obstacleGrid.length;

        int[][] solns = new int[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                solns[i][j] = -1;
            }
        }

        if (obstacleGrid[rows-1][cols-1] == 1) {
            return 0;
        }
        return uniquePathsWithObstacles(obstacleGrid, rows-1, cols-1, solns);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int rows, int cols, int[][] solns) {
        if (rows == 0 && cols == 0) {
            if (obstacleGrid[rows][cols] != 1) {
                return 1;
            } else {
                return 0;
            }
        }

        int totalPaths = 0;
        if (rows > 0) {
            if (obstacleGrid[rows-1][cols] != 1) {
                if (solns[rows-1][cols] == -1) {
                    solns[rows-1][cols] = uniquePathsWithObstacles(obstacleGrid, rows-1, cols, solns);
                }
                totalPaths += solns[rows-1][cols];
            }
        }

        if (cols > 0) {
            if (obstacleGrid[rows][cols-1] != 1) {
                if (solns[rows][cols-1] == -1) {
                    solns[rows][cols-1] = uniquePathsWithObstacles(obstacleGrid, rows, cols-1, solns);
                }
                totalPaths += solns[rows][cols-1];
            }
        }

        return totalPaths;
    }
}
