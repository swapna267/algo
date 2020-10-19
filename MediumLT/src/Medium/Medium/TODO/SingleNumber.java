package Medium.Medium.TODO;

public class SingleNumber {
  //Given an array of integers, every element appears twice except for one. Find that single one.
  public static void main(String[] args) {
    int[] A = {10,10,20,30,30};
    singleNumber(A);
  }

  public static int singleNumber(int[] A) {
    int x = 0;
    for (int a : A) {
      x = x ^ a;
      System.out.println(x);
    }
    return x;
  }
}
