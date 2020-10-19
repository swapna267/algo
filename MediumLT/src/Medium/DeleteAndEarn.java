package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    List<Integer> input = new ArrayList<>();
    for(int i=0; i<nums.length;i++) {
      input.add(nums[i]);
    }
    Collections.sort(input);

    int[][] solutions = new int[nums.length][nums.length];
    for(int i=0;i<nums.length;i++) {
      for(int j=0;j<nums.length;j++) {
        solutions[i][j] = 0;
      }
    }

    solutions[0][0] = input.get(0);

    for(int j=1;j<nums.length;j++) {
      for(int i=j;i<=0;i--) {
        solutions[i][j] = 0;

        //Max of
        for (int k=i;k<=j;k++) {
          int currPoints = input.get(k);

          if (k+1<=j && (input.get(k+1) == input.get(k)+1) && k+2<=j) {
            currPoints += solutions[k+2][j];
          } else if (k+1<=j && (input.get(k+1) != input.get(k)+1) ){
            currPoints += solutions[k+1][j];
          }

          if (k-1>=i && (input.get(k-1) == input.get(k)-1) && k-2<=i) {
            currPoints += solutions[k-2][j];
          } else if (k-1>=j && (input.get(k-1) != input.get(k)-1)){
            currPoints += solutions[k-1][j];
          }

          solutions[i][j] = Math.max(currPoints, solutions[i][j]);
        }
      }
    }
    return solutions[0][nums.length-1];
  }
}
