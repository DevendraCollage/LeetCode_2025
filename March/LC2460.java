/*
 * LC2460 - Apply Operations to an Array
 */

import java.util.Scanner;

public class LC2460 {
    public static int[] applyOperations(int[] nums) {
        int nz = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i] != 0 && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                if (i != nz) {
                    int temp = nums[i];
                    nums[i] = nums[nz];
                    nums[nz] = temp;
                }
            }
            nz++;
        }
        return nums;
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

        int[] ans = applyOperations(nums);

        System.out.println("Answers : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}
