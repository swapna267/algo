package Medium;

public class PalindromicSubsequence {
  public static void main(String[] args) {
    String str = "bbba";
    char[] c = str.toCharArray();
    int[] longestSubs = new int[c.length];

    int max = 1;
    for (int endIndex=0;endIndex<c.length;endIndex++) {
      int[] temp = new int[c.length];
      temp[endIndex] = 1;
      max = 1;
      for (int startIndex=endIndex-1;startIndex>=0;startIndex--) {
         if (c[startIndex] == c[endIndex]) {
           temp[startIndex] = 2;
           if (endIndex - startIndex > 1) {
             temp[startIndex] += longestSubs[startIndex+1];
           }
         } else {
           temp[startIndex] = Math.max(max,longestSubs[startIndex]);
         }

         max = Math.max(max, temp[startIndex]);
      }
      longestSubs = temp;
    }

    System.out.println(max);
  }
}
