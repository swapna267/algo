package Medium.Medium;

import java.util.ArrayList;
import java.util.List;

public class NumIslands {
    public int numIslands(char[][] grid) {
      int numIslands = 0;
      int rows = grid.length;
      int cols = grid[0].length;
      boolean[][] visited =  new boolean[rows][cols];

      for (int row=0;row<rows;row++) {
        for (int col=0;col<cols;cols++) {
          if (visited[row][col] || grid[row][col] == '0') {
            continue;
          }

          if (grid[row][col] == '1') {
              visited[row][col] = true;
              numIslands++;

            List<int[]> gridEntry = new ArrayList();
            gridEntry.add(new int[]{row,col});
            while (!gridEntry.isEmpty()) {
              int[] curr = gridEntry.remove(0);
              int r = curr[0];
              int c = curr[1];
              if (r+1 < rows && grid[r+1][c] == '1' && !visited[r+1][c]) {
                gridEntry.add(new int[]{r+1,c});
                visited[r+1][c] = true;
              }

              if (r-1 > 0 && grid[r-1][c] == '1' && !visited[r-1][c]) {
                gridEntry.add(new int[]{r-1,c});
                visited[r-1][c] = true;
              }

              if (c+1 < cols && grid[r][c+1] == '1' && !visited[r][c+1]) {
                gridEntry.add(new int[]{r,c+1});
                visited[r][c+1] = true;
              }

              if (c-1 > 0 && grid[r][c-1] == '1' && !visited[r][c-1]) {
                gridEntry.add(new int[]{r,c-1});
                visited[r+1][c] = true;
              }
            }

          }
        }
      }
      return numIslands;

    }
}
