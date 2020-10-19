package easy;

/*
IMP: ASCII indexes. A .. Z, a ... z
 */
public class StonesAndJewels {
  public int numJewelsInStones(String J, String S) {
    int len = 'z' - 'A';
    int[] jewelMap = new int[len+1];

    char[] jewelArr = J.toCharArray();
    for (int i=0;i<jewelArr.length;i++) {
      int index = jewelArr[i]-'A';
      jewelMap[index] = 1;
    }

    char[] stonesArr = S.toCharArray();
    int total = 0;
    for (int i=0;i<stonesArr.length;i++) {
      int index = stonesArr[i]-'A';
      if (jewelMap[index] == 1) {
        total++;
      }
    }
    return total;
  }
}
