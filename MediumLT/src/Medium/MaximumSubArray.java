package Medium;

/*
*
* Given an integer array nums,
* find the contiguous subarray (containing at least one number) which has the largest sum and return its sum*/
public class MaximumSubArray {

  public int getMaxSum(int[] array) {
    int max = array[0];
    int localMax = array[0];
    int size = array.length;

    for (int i=1;i<size;i++) {
      localMax = Math.max(localMax + array[i], array[i]);
      max = Math.max(localMax, max);
    }

    return max;
  }


}
