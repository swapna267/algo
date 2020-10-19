package Medium.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DistinctIslands {
  public static void main(String[] args) {

  }

  public static int getNumDistinctIslands(int[][] input,int rows, int cols) {
    int islandNum = 2;
    Set<List<int[]>> set = new TreeSet<>(new Comparator<List<int[]>>() {
      @Override
      public int compare(List<int[]> o1, List<int[]> o2) {
        if (o1.size() != o2.size()) {
          return  -1;
        }

        for (int i=1;i<o1.size();i++) {
          int[] curr1 = o1.get(i);
          int[] prev1 = o1.get(i-1);

          int[] curr2 = o2.get(i);
          int[] prev2 = o2.get(i-1);

          if (curr1[0] - prev1[0] == curr2[0] - prev2[0]) {
            if (curr1[1] - prev1[1] == curr2[1] - prev2[1]) {
                return 0;
            }
          }
        }
        return -1;
      }
    });

    for (int i=0;i<rows;i++) {
      for (int j=0;j<cols;j++) {
        if (input[i][j] == 1) {
          List<int[]> currIsland = new ArrayList<>();
          input[i][j] = islandNum++;
          traverse(input, i , j, rows, cols, currIsland);
          Collections.sort(currIsland, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
              if (o1[0] == o2[0]) {
                return o1[0]-o1[1];
              }

              return o1[0] - o2[0];
            }
          });


          set.add(currIsland);
        }
      }
    }

    return set.size();
  }

  //row+1,col , row-1,col, row, col+1 , row, col-1
  public static void traverse(int[][] input, int row, int col, int rows, int cols,List<int[]> currIsland) {
    if (row-1 >= 0) {
      if (input[row-1][col] == 1) {
        input[row-1][col] = input[row][col];
        currIsland.add(new int[]{row-1,col});
        traverse(input, row-1, col, rows, cols, currIsland);
      }
    }

    if (row+1 < rows) {
      if (input[row+1][col] == 1) {
        input[row+1][col] = input[row][col];
        currIsland.add(new int[]{row+1,col});
        traverse(input, row+1, col, rows, cols, currIsland);
      }
    }

    if (col-1 >= 0) {
      if (input[row][col-1] == 1) {
        input[row][col-1] = input[row][col];
        currIsland.add(new int[]{row,col-1});
        traverse(input, row, col-1, rows, cols, currIsland);
      }
    }

    if (col+1 < cols) {
      if (input[row][col+1] == 1) {
        input[row][col+1] = input[row][col];
        currIsland.add(new int[]{row,col+1});
        traverse(input, row, col+1, rows, cols, currIsland);
      }
    }
  }
}
