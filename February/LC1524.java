/*
 * LC1524 - Number of Sub-arrays With Odd Sum
 */

import java.util.*;

public class LC1524 {
    public static int numOfSubarrays(int[] arr) {
        int Mod = 1000000007;
        int evenC = 1;
        int oddC = 0;
        int prefix = 0;
        int res = 0;
        for (int num : arr) {
            prefix += num;
            // Prefix sum is even
            if (prefix % 2 == 0) {
                res += oddC;
                evenC++;
            }
            // is odd
            else {
                res += evenC;
                oddC++;
            }
            res = res % Mod;
        }

        return res;
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

        int ans = numOfSubarrays(arr);

        System.out.println(ans);

        sc.close();
    }
}