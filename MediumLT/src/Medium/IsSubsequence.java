package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
      List<List<Integer>> positions = new ArrayList();
      char[] c = t.toCharArray();

      for (int i=0;i<c.length;i++) {
        int index = c[i]-'a';
        List<Integer> list = positions.get(index);
        if (list == null) {
          list = new ArrayList();
          list.add(i);
          positions.add(index, list);
        } else {
          list.add(i);
        }
      }

      char[] sc = s.toCharArray();
      int first = -1;
      for (int i=0;i<sc.length;i++) {
        int index = sc[i] - 'a';
        List<Integer> currCharPositions = positions.get(index);
        int foundIndex = Collections.binarySearch(currCharPositions, first);
        if (foundIndex >=0 ) {
          return false;
        }

        if (-1*(foundIndex+1) == currCharPositions.size()) {
          return false;
        }

        first = -1*(foundIndex+1);
      }

      return true;
    }

}
