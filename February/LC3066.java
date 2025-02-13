/*
 * LC3066 - Minimum Operations to Exceed Threshold Value II
 */

import java.util.*;

public class LC3066 {
    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : nums) {
            pq.offer(num);
        }

        int op = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            long res = x + 2 * y;
            pq.offer(res);
            op++;
        }

        return pq.peek() >= k ? op : -1;
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

        System.out.print("Enter The k : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = minOperations(nums, k);

        System.out.println(ans);

        sc.close();
    }
}