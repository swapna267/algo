package Medium;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class LongestArithmeticSeq {
  public static void main(String[] args) {
    int[] a = {44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28};
    int maxEle = 10000;


    List<List<Integer>> map = new ArrayList(maxEle+1);
    for (int i=0;i<=maxEle;i++) {
      map.add(i,new ArrayList<>());
    }
    for (int i=0;i<a.length;i++) {
      map.get(a[i]).add(i);
    }

    boolean[][] traversed = new boolean[a.length][2*maxEle+1];

    int maxLen = 0;
    for (int i=0;i<a.length-2;i++) {
      for (int j=i+1;j<a.length-1;j++) {
      //  System.out.println(j+i);
        int diff = a[j]-a[i];
        if (traversed[j][diff+maxEle]) {
          continue;
        }
        traversed[j][diff+maxEle] = true;
        int len = 2;
        int prevIndex = j;
        int nextEle = a[j]+diff;
        while (nextEle <= maxEle && nextEle >=0) {
          boolean found = false;
          for (int index:map.get(nextEle)) {
            if (index > prevIndex) {
              found = true;
              prevIndex = index;
              len++;
              traversed[prevIndex][diff+maxEle] = true;
              nextEle += diff;
              break;
            }
          }

          if (!found) {
            break;
          }

        }
        maxLen = Math.max(maxLen, len);
      }
    }

    System.out.println(maxLen);
  }
}
