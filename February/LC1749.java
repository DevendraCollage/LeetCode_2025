/*
 * LC1749 - Maximum Absolute Sum of Any Subarray
 */

import java.util.*;

public class LC1749 {
    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int curPSum = 0;
        int curNSum = 0;
        for (int num : nums) {
            // for Positive
            curPSum += num;
            maxSum = Math.max(maxSum, curPSum);
            if (curPSum < 0) {
                curPSum = 0;
            }

            // for Negative
            curNSum += num;
            minSum = Math.min(minSum, curNSum);
            if (curNSum > 0) {
                curNSum = 0;
            }
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Nums Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        int ans = maxAbsoluteSum(nums);

        System.out.println(ans);

        sc.close();
    }
}