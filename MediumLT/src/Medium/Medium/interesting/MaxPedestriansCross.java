package Medium.Medium.interesting;

import java.util.Arrays;

public class MaxPedestriansCross {
  public static void main(String[] args) {
    int[][] intervals = {{1,9},{2,4},{3,9}};

    int[] startTime = extractIndex(0, intervals);
    int[] endTime = extractIndex(1, intervals);

    Arrays.sort(startTime);
    Arrays.sort(endTime);

    int[] interval = new int[2];
    int maxPas = 0;
    int stIndex = 0;

    for (int i=0;i<endTime.length;i++) {
      //keep moving till starttime < endtime
      while(stIndex < startTime.length && startTime[stIndex] <= endTime[i]) {
        stIndex++;
      }

      int numP = stIndex - i;
      if (numP > maxPas) {
        maxPas = numP;
        interval[0] = startTime[stIndex-1];
        interval[1] = endTime[i];
      }
    }

    System.out.println(maxPas);
    System.out.println(interval[0]+":"+interval[1]);
  }

  public static int[] extractIndex(int index, int[][] intervals) {
    int[] indexInt = new int[intervals.length];
    for (int i=0;i<intervals.length;i++) {
      indexInt[i] = intervals[i][index];
    }
    return indexInt;
  }

}
