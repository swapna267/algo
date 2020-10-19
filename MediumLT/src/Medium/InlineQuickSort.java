package Medium;

public class InlineQuickSort {

  public static void  main(String[] args) {
    int arr1[] = {1,2,0};
    partition(arr1, 0 , 2);
  }

  public  static void partition(int arr[], int low, int high)
  {
    int i = -1, j = low, k= high+1;


    while (j<k) {
      System.out.println(i+":"+j+":"+k);
      if (arr[j] < 1) {
        //swap i with j
        i++;
        arr[j] = arr[i];
        arr[i] = 0;
        j++;
        continue;
      }

      if (arr[j] == 1) {
        j++;
        continue;
      }

      if (arr[j] > 1) {
        //swap j with k
        k--;
        arr[j] = arr[k];
        arr[k] = 2;
        continue;
      }


      for (int temp=0;temp<arr.length;temp++) {
        System.out.println(arr[temp]);
      }
      System.out.println("*****");
    }

    for (int temp=0;temp<arr.length;temp++) {
      System.out.println(arr[temp]);
    }
  }
}
