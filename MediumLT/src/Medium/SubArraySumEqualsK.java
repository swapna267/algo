package Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
  public static void main(String[] args) {
    int[] a = {1, 4, 20, 3, 10, 5};
    int sum = 33;

    int totalCombs = 0;
    int totalSum = 0;
    Integer totalCombsWithSum;
    Map<Integer,Integer> index = new HashMap<>();
    for (int i=0;i<a.length;i++) {

      if (a[i] == sum) {
        totalCombs++;
      }

      totalSum += a[i];
      int diff = sum-totalSum;

      if ((totalCombsWithSum=index.get(diff)) != null) {
        totalCombs += totalCombsWithSum;
      }

    //        index.getOrDefault();
      index.compute(totalSum, (k,v1) -> v1==null?1:v1+1);
    }

    System.out.println(totalCombs);
  }
}
