package Medium.Medium;

public class PartitionDisjoint {
  public static void main(String[] args) {

    int[] a = {5,0,3,8,6};
    int[] minRight = new int[a.length -1];
    int[] maxLeft = new int[a.length-1];

    int temp = Integer.MAX_VALUE;
    for (int i=a.length-1;i>0;i--) {
      if (a[i] < temp ) {
        temp = a[i];
      }
      minRight[i-1] = temp;
    }

    temp = Integer.MIN_VALUE;
    for (int i=0;i<a.length-1;i++) {
      if (a[i] > temp) {
        temp = a[i];
      }
      maxLeft[i] = temp;
    }

    for (int i=0;i<a.length-1;i++) {
      if (minRight[i] >= maxLeft[i]) {
        System.out.println(i+1);
      }
    }
  }
}
