package Medium.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/*
T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class DailyTemps {
  public static void main(String[] args) {
    int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};

    Stack<Integer> stack = new Stack();

    int[] output = new int[temps.length];
    stack.push(0);
    for (int i=1;i<temps.length;i++) {
      while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
        int prevIndex = stack.pop();
        output[prevIndex] = i-prevIndex;
      }
      stack.push(i);
    }

    System.out.println(Arrays.toString(output));
  }

}
