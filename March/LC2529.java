/*
 * LC2529 - Maximum Count of Positive Integer and Negative Integer  
 */

import java.util.Scanner;

public class LC2529 {
    public static int maximumCount(int[] nums) {
        int n = nums.length;

        int negCount = binrarySearch(nums, 0);
        int posCount = n - binrarySearch(nums, 1);
        return Math.max(negCount, posCount);
    }

    public static int binrarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length; // If not found

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Length of the Nums Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        int ans = maximumCount(nums);

        System.out.println(ans);

        sc.close();
    }
}
