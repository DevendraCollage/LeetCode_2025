/*
 * LC2364 - Count Number of Bad Pairs
 */

import java.util.*;

public class LC2364 {
    public static long countBadPairs(int[] nums) {
        long n = nums.length;
        long goodPairs = 0;
        long totalPairs = n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = i - nums[i];
            int prevCount = map.getOrDefault(val, 0);
            goodPairs += prevCount;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return totalPairs - goodPairs;
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

        long ans = countBadPairs(nums);

        System.out.println(ans);

        sc.close();
    }
}