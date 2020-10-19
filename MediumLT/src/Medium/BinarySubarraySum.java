package Medium;

/*
Start = 0
End = 0
Total
totalCombsWithPrevEnd

for(end<len;end++)
Sum += a[end]
if(sum < S)
  totalCombsWithPrevEnd = 0
  Continue

If sum == S
  totalCombsWithPrevEnd+=1
  while(start < end)
    sum = sum - A[start]
    start++
    If (sum == S)
      totalCombsWithPrevEnd+=1
    Else
       Break

total+=totalCombsWithPrevEnd
 */
public class BinarySubarraySum {
  public int numSubarraysWithSum(int[] A, int S) {
    if (A.length == 0) {
      return 0;
    }

    int totalCombs = 0;
    int start = 0;
    int end = 0;
    int sum = -1;

    //Move end till sum > S
    // Move start till sum < S
    for (;start < A.length && end < A.length;) {
      if (sum == S) {
        totalCombs++;
        if (start < end) {
          start++;
        } else {
          end++;
        }
      }

      if (sum < S) {
        sum += A[end];
        end++;
      }

      if (sum > S) {
        sum -= A[start];
        start++;
      }

    }


    return totalCombs;
  }



}
