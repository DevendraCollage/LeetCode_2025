/*
 * LC1800 - Maximum Ascending Subarray Sum
 */

import java.util.Scanner;

public class LC1800 {
    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int r = 1;
        int sum = nums[0];
        int max_sum = nums[0];

        while (r < n) {
            while (r < n && nums[r] > nums[r - 1]) {
                sum += nums[r];
                r++;
            }
            max_sum = Math.max(max_sum, sum);
            if (r < n) {
                sum = nums[r];
            }
            r++;
        }

        return max_sum;
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

        int ans = maxAscendingSum(nums);

        System.out.println(ans);

        sc.close();
    }
}
