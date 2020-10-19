package Design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage1 {
  public static void main(String[] args) {
    MovingAverage m = new MovingAverage(3);
    System.out.println(m.next(1));
    System.out.println(m.next(10));
    System.out.println(m.next(3));
    System.out.println(m.next(5));
  }

  public static class MovingAverage {
    Deque<Integer> q = new ArrayDeque();
    int windowSize;
    int currSum = 0;

    /*
    * @param size: An integer
    */public MovingAverage(int size) {
      // do intialization if necessary
      this.windowSize = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
      // write your code here
      if (q.size() < windowSize) {
        q.addLast(val);
        currSum += val;

      } else {
        int ele = q.removeFirst();
        currSum -= ele;
        currSum += val;
        q.addLast(val);
      }

      return (double)currSum/q.size();
    }
  }
}

