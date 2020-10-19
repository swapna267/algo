package Medium.Medium;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class ThreeSum {

  public static void main() {

  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<Integer> list = new ArrayList();
    for (int i=0;i<nums.length;i++) {
      list.add(i,nums[i]);
    }

    Collections.sort(list);

    List<List<Integer>> output = new ArrayList();
    for (int i=0;i<list.size()-2;) {
      int firstEle = list.get(i);
      int targetSum = -1*firstEle;
      //find other 2 with sum = -firstEle
      int front = i+1;
      int rear = list.size()-1;
      for (;front<rear;) {
        if(list.get(front) + list.get(rear) >targetSum) {
          rear--;
        } else if (list.get(front) + list.get(rear) <targetSum) {
          front++;
        } else {
          List<Integer> soln = new ArrayList();
          int secondEle = list.get(front);
          soln.add(firstEle);
          soln.add(secondEle);
          soln.add(list.get(rear));
          output.add(soln);
          front++;

          while(list.get(front) == secondEle && front<rear) {
           front++;
          }
        }
      }

      while(list.get(i) == firstEle && i<list.size()-2) {
        i++;
      }
    }

    return output;
  }
}