package Medium.Medium;

/*
Input:
1 2 3 4 5 6 7 8 9
1 3 1 5 6 7 2 5 2
wall volume: 5
Output: 33333

1 1 2 2 3 5 6 7
1 3 7 9 2 4 5 6

1 - 3
2 -

max(w) -
vol -> 1 to 5
 i -> 0 to numbers
   numVol = v(i)
   num = num(i)
   if (v(i) > Vol) br
   num = addTo(max(vol-numVol), num)
   max(w) = max(num,max(w))

*/

import java.util.Arrays;

public class Wall_G {

    public static void main(String[] args) {
        int[][] numVolumes = {{1,1},{2,3},{3,1},{4,5},{5,6},{6,7},{7,2},{8,5},{9,1}};
        Arrays.sort(numVolumes, (int[] a,int[] b) -> a[1]-b[1]);

        int totVol = 5;
        int[] maxNum = new int[totVol+1];
        maxNum[0] = 0;

        for (int vol=1;vol<=totVol;vol++) {
            for (int[] digit : numVolumes) {
                if (digit[1] > vol) {
                    break;
                }

                maxNum[vol] = Math.max(maxNum[vol], addNumLast(maxNum[vol-digit[1]], digit[0]));
            }
        }

        System.out.println(maxNum[totVol]);
    }

    public static int addNumLast(int num1, int digit) {
        return num1*10+digit;
    }
}
