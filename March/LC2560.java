/*
 * LC2560 - House Robber IV
 */

import java.util.*;

public class LC2560 {
    public static int minCapability(int[] nums, int k) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > end) {
                end = num;
            }
            if (num < start) {
                start = num;
            }
        }

        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isRobberyPossible(mid, nums, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isRobberyPossible(int capability, int[] nums, int minHouses) {
        int housesRobbed = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                housesRobbed++;
                i++; // skipped for adjacent condition
            }
            if (housesRobbed >= minHouses) {
                return true;
            }
        }

        return false;
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

        System.out.print("Enter The Integer K : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = minCapability(nums, k);

        System.out.println(ans);

        sc.close();
    }
}