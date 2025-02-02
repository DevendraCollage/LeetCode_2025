/*
 * LC1752 - Check if Array Is Sorted and Rotated
 */

import java.util.Scanner;

public class LC1752 {
    public static boolean check(int[] nums) {
        final int n = nums.length;
        int rotates = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n] && ++rotates > 1) {
                return false;
            }
        }

        return true;
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

        boolean ans = check(nums);

        System.out.println(ans);

        sc.close();
    }
}
