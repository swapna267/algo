package Medium.Medium;

public class PrisonT {
    public int[] prisonAfterNDays(int[] cells, int N) {
       //find cycle len
       int[] input = cells;

       int cycleWidth = 0;

       for (int day=0;day<N;day++) {
            input = getTransformedAfterDay(input);
            if (input == cells) {
              cycleWidth = day;
              break;
            }
       }

       int n = N%cycleWidth;
      for (int day=0;day<n;day++) {
        input = getTransformedAfterDay(input);
      }

      
      return input;
    }

    public int[] getTransformedAfterDay(int[] input) {
      int[] temp = new int[input.length];
      for (int i=1;i<input.length-1;i++) {
        if (input[i-1] == input[i+1]) {
          temp[i] = 0;
        } else {
          temp[i] = 1;
        }
      }
      return temp;
    }
}
