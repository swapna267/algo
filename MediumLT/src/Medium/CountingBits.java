package Medium;

/*
Given a non negative integer number num.
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Idea is to
5 is represented as 4 +1
6 -> 4+2
7 -> 4+3
8 -> 1 (when it reaches twice starting number reset to 1)
9 -> 8+1
10 -> 8 +2 ..... 8+7
16 -> 1
 */
class CountingBits {
  public int[] countBits(int num) {
    int[] numBits = new int[num+1];
    numBits[0] = 0;

    for (int i=1;i<=num;i=i*2) {
      numBits[i] = 1;
      for (int j=1; j<i && i+j<=num; j++) {
        numBits[i+j] = numBits[i] + numBits[j];
      }
    }

    return numBits;
  }
}
