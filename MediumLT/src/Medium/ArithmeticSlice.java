package Medium;

public class ArithmeticSlice {
  public int numberOfArithmeticSlices(int[] A) {
      int total = 0;

      if (A.length < 3) {
        return 0;
      }

    int startIndexOfSlice = 0;
    int currDiff = A[1]-A[0];

      for (int i=2;i<A.length;i++) {
        if (A[i]-A[i-1] == currDiff) {
          if (i-startIndexOfSlice > 1) {
            total += (i-startIndexOfSlice-1);
          }
        } else {
          startIndexOfSlice = i-1;
          currDiff = A[i]-A[i-1];
        }
      }

      return total;
  }
}
