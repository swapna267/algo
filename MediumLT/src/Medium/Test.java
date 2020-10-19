package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
  public  static void main(String[] args) {
    List<Integer> list = new ArrayList();
    list.add(0);
 //   list.add(5);
    System.out.println(Collections.binarySearch(list,2));
  }
}
