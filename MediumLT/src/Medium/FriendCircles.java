package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// IMP NOTE: Don't modify the map while iterating the MAP*****
public class FriendCircles {
  public static void main(String[] args) {

    int[][] relations = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1 , 1}
    };

    int[][] relations2 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0 , 1}
    };

    System.out.println(getNumFriendCircles(relations2));
  }
  public static int getNumFriendCircles(int[][] relations) {
    if (relations.length == 0) return 0;
    if (relations.length == 1) return 1;

    int n = relations.length;
    //index - student, value - circleId
    int[] circleIds = new int[n];
    for (int i=0;i< n ;i++) {
      circleIds[i] = -1;
    }

    for (int i = 0; i < n; i++) {
      int currentCircle = -1;
      for (int j = 0; j < i; j++) {
        if (relations[i][j] == 1) {
          int circleIdOfJ = circleIds[j];
          if (currentCircle == -1) {
            circleIds[i] = circleIdOfJ;
            currentCircle = circleIdOfJ;
          } else {
            if (currentCircle != circleIdOfJ) {
              for (int k = 0; k <= i; k++) {
                if (circleIds[k] == circleIdOfJ) {
                  circleIds[k] = currentCircle;
                }
              }
            }
          }

          // find circle with j
          // if not added add to that circle
          // if added already, merge c2 with c1
        }
      }
      if (currentCircle == -1) {
        circleIds[i] = i;
      }
    }

    Set<Integer> uniqueCircles = new HashSet<>(n);
    for (int i=0;i<n;i++){
      uniqueCircles.add(circleIds[i]);
    }
    return uniqueCircles.size();
  }
}
