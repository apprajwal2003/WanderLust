import java.util.*;

public class demo {

  // binary search
  public static int binarySearch(int arr[], int key) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int midInd = (start + end) / 2;
      if (arr[midInd] == key) {
        return midInd;
      } else if (arr[midInd] > key) {
        end = midInd - 1;
      } else {
        start = midInd + 1;
      }
    }
    return -1;
  }

  // Print sub Array
  public static void printSubArrays(int arr[]) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        for (int start = i; start <= j; start++) {
          sum += arr[start];
          System.out.print(arr[start] + " ");
        }
        System.out.println("Sum = " + sum);
        if (sum < min) {
          min = sum;
        }
        if (sum > max) {
          max = sum;
        }
        sum = 0;
      }
    }
    System.out.println("Max is: " + max + ",Min is: " + min);
  }

  public static int maxSubArraySum(int arr[]) {
    int max = Integer.MIN_VALUE;
    int curr = 0;
    for(int i = 0; i < arr.length; i++) {
      curr += arr[i];
      if (curr < 0) {
        curr = 0;
      }
      if(max < curr) {
        max = curr;
      }
    }
    return max;
  }


  public static int fib(int n, int dp[]) {
    if(n<=1) {
      return n;
    }
    if(dp[n] != -1) {
      return dp[n];
    }
    dp[n] = fib(n-1, dp) + fib(n-2, dp);
    return dp[n];
  }

  public static void main(String[] args) {
    // int arr[] = { 3, -7, 12, -4, 9, -1, 6, -8, 15, -2 };
    // int dp[] = new int[10];
    // for(int i = 0; i < dp.length; i++) {
    //   dp[i] = -1;
    // }
    // System.out.println(fib(6, dp));
    // System.out.println("Index of the key is : " + binarySearch(arr, 8));
    // printSubArrays(arr);
    // System.out.println((maxSubArraySum(arr)));

  }

  
}