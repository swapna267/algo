package Medium;

import java.util.ArrayList;
import java.util.List;

/*
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
*
* */
public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> dp = new ArrayList();
    int row = 1;

    for (List<Integer> row1 : triangle) {
      int col = 0;
      int prevRowStartIndex = 0;
      for (Integer val : row1) {
        if (prevRowStartIndex > 0) {

        }

      }
    }
    return 0;
  }
}
