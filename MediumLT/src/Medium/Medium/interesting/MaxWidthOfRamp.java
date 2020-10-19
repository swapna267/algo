package Medium.Medium.interesting;

import java.util.Arrays;

/*

Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

The idea is 1). remember the minimum index and maximum index for each appeared number.
 2) then start from the smallest number to the largest number,
construct the maximum ramp or range window from the information of the start and end index array.
 */
public class MaxWidthOfRamp {
    public int maxWidthRamp(int[] A) {
      int n = A.length, res = 0, minimum = 50001;
      int[] min_idx = new int[50001], max_idx = new int[50001];
      Arrays.fill(min_idx, 50001);
      Arrays.fill(max_idx, -1);
      for(int i = 0; i < n; i++){
        min_idx[A[i]] = Math.min(i, min_idx[A[i]]);
        max_idx[A[i]] = Math.max(i, max_idx[A[i]]);
      }
      for(int i = 0; i < 50001; i++){
        if(min_idx[i] == 50001) continue;
        minimum = Math.min(minimum, min_idx[i]);
        res = Math.max(res, max_idx[i] - minimum);
      }
      return res;
    }

}
