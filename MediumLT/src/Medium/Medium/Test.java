package Medium.Medium;

// Java implementation to find the length
// of longest subarray having sum k
import java.io.*;
import java.util.*;

class Test {

  // function to find the length of longest
  // subarray having sum k
  static int lenOfLongSubarr(int[] arr, int n, int k)
  {
    // HashMap to store (sum, index) tuples
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0, maxLen = 0;

    // traverse the given array
    for (int i = 0; i < n; i++) {

      // accumulate sum
      sum += arr[i];

      // when subarray starts from index '0'
      if (sum == k)
        maxLen = i + 1;

      // make an entry for 'sum' if it is
      // not present in 'map'
      if (!map.containsKey(sum)) {
        System.out.println(sum);
        map.put(sum, i);
      }

      // check if 'sum-k' is present in 'map'
      // or not
      if (map.containsKey(sum - k)) {
        System.out.println("Found"+ (sum-k));
        // update maxLength
        if (maxLen < (i - map.get(sum - k)))
          maxLen = i - map.get(sum - k);
      }
    }

    return maxLen;
  }

  // Driver code
  public static void main(String args[])
  {
    int[] arr = {1, -2, 2, 3, -3};
    int n = arr.length;
    int k = 0;
    System.out.println("Length = " +
            lenOfLongSubarr(arr, n, k));
  }
}
