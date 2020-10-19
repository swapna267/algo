package Medium.Medium;

import java.util.Arrays;

public class LongestSubstrWithKDistinctEle {
  public static void main(String[] args) {
    String str = "ababccc";
    int k = 2;
    char[] s = str.toCharArray();
    int[] counts = new int[26];
    Arrays.fill(counts,0);


    int start = 0;
    int end = 0;
    int globalMax = 1;

    int pos = s[0] - 'a';
    counts[pos]++;

    for (int i=1;i<s.length;i++) {
      pos = s[i] - 'a';
      counts[pos]++;
      end++;

      while(getDistinctEle(counts) > k) {
        pos = s[start] - 'a';
        counts[pos]--;
        start++;
      }

      globalMax = Math.max(globalMax, end-start+1);
    }

    System.out.println(globalMax);

  }

  public static int getDistinctEle(int[] counts) {
    int distinct = 0;
    for (int i=0;i<counts.length;i++) {
      if (counts[i] > 0) {
        distinct++;
      }
    }
    return distinct;
  }
}
