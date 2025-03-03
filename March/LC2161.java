/*
 * LC2161 - Partition Array According to Given Pivot
 */

import java.util.Scanner;

public class LC2161 {
    public static int[] pivotArray(int[] nums, int pivot) {
        int lCount = 0;
        int gCount = 0;
        int pCount = 0;
        for (int num : nums) {
            if (num < pivot) {
                lCount++;
            } else if (num > pivot) {
                gCount++;
            } else {
                pCount++;
            }
        }

        int i = 0;
        int j = lCount;
        int k = lCount + pCount;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num < pivot) {
                res[i] = num;
                i++;
            } else if (num > pivot) {
                res[k] = num;
                k++;
            } else {
                res[j] = num;
                j++;
            }
        }

        return res;
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

        System.out.print("Enter The Pivot Element : ");
        int pivot = sc.nextInt();
        System.out.println();

        int[] ans = pivotArray(nums, pivot);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}