/*
 * LC3105 - Longest Strictly Increasing or Strictly Decreasing Subarray
 */

import java.util.*;

public class LC3105 {
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int i = 1;
        int ans = 1;
        while (i < n) {
            int temp = 1;
            if (nums[i] > nums[i - 1]) {
                while (i < n && nums[i] > nums[i - 1]) {
                    i++;
                    temp++;
                }
            } else if (nums[i] < nums[i - 1]) {
                while (i < n && nums[i] < nums[i - 1]) {
                    i++;
                    temp++;
                }

            } else {
                i++;
            }

            if (temp > ans) {
                ans = temp;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        int ans = longestMonotonicSubarray(nums);

        System.out.println(ans);

        sc.close();
    }
}