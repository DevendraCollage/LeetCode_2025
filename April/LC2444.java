/* 
 * LC2444 - Count Subarrays With Fixed Bounds
 */

import java.util.Scanner;

public class LC2444 {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long validSubarrays = 0;
        int invalidIdx = -1;
        int minIdx = -1;
        int maxIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                invalidIdx = i;
            }
            if (nums[i] == minK) {
                minIdx = i;
            }
            if (nums[i] == maxK) {
                maxIdx = i;
            }

            int count = Math.max(Math.min(minIdx, maxIdx) - invalidIdx, 0);
            validSubarrays += count;
        }

        return validSubarrays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size of the nums Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The elements of the nums array : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println();

        System.out.println("Enter The value of minK : ");
        int minK = sc.nextInt();
        System.out.println();

        System.out.println("Enter The value of maxK : ");
        int maxK = sc.nextInt();
        System.out.println();

        long ans = countSubarrays(nums, minK, maxK);

        System.out.println(ans);

        sc.close();
    }
}