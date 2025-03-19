/*
 * LC3191 - Minimum Operations to Make Binary Array Elements Equal to One I
 */

import java.util.*;

public class LC3191 {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < (n - 2); i++) {
            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count++;
            }
        }

        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            return -1;
        }

        return count;
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

        int ans = minOperations(nums);

        System.out.println(ans);

        sc.close();
    }
}