/*
 * LC873 - Length of Longest Fibonacci Subsequence
 */

import java.util.*;

public class LC873 {
    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen = 0;
        for (int i = 2; i < n; i++) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum < arr[i]) {
                    start++;
                } else if (sum > arr[i]) {
                    end--;
                } else {
                    dp[end][i] = dp[start][end] + 1;
                    maxLen = Math.max(maxLen, dp[end][i]);
                    start++;
                    end--;
                }
            }
        }

        return maxLen == 0 ? 0 : maxLen + 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] arr = new int[n];

        System.out.println("Enter The Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] : ", i);
            arr[i] = sc.nextInt();
        }
        System.out.println();

        int ans = lenLongestFibSubseq(arr);

        System.out.println(ans);

        sc.close();
    }
}