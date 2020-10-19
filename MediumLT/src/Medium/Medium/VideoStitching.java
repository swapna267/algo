package Medium.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class VideoStitching {
  public static void main(String[] args) {
    int[][] a = {
            {0,2},
            {4,6},
            {8,10},
            {1,9},
            {1,5},
            {5,9}
    };
     videoStitching(a, 10);
  }
//[[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]
  //0,2  1,5   1,9    4,6   5,9   8,10
  public static int videoStitching(int[][] clips, int T) {

    new PriorityQueue();
    Arrays.sort(clips, (int[] a, int[] b) -> a[0] - b[0]);
      Arrays.sort(clips, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
          if (a[0] == b[0]) {
            return a[1]-b[1];
          } else {
            return a[0]-b[0];
          }
        }
      });

      int[] numClips = new int[T+1];
      Arrays.fill(numClips, clips.length+1);
      for (int i=0;i<clips.length;i++) {
          int start = clips[i][0];
          int end = clips[i][1];
          System.out.println(start + ":"+ end);

          for (int j=start;j<=end;j++) {
            int totalClips = 1;
            if (start > 0) {
              if (numClips[start-1] > clips.length) {
                return -1;
              }
              totalClips += numClips[start-1];
            }

            numClips[j] = Math.min(totalClips, numClips[j]);
          }
      }

      SortedMap map = new TreeMap<>();
      map.firstKey();
      return numClips[T] > clips.length ? -1: numClips[T];
  }
}
