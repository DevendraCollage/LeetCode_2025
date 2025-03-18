/*
 * LC2401 - Longest Nice Subarray
 */

import java.util.*;

public class LC2401 {
    public static int longestNiceSubarray(int[] nums) {
        int start = 0;
        int maxLen = 0;
        int bitMask = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // shrinking
            while ((bitMask & nums[i]) != 0) {
                bitMask = bitMask ^ nums[start];
                start++;
            }
            bitMask = bitMask | nums[i];
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size of Nums Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        int ans = longestNiceSubarray(nums);

        System.out.println(ans);

        sc.close();
    }
}