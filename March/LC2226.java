/*
 * LC2226 - Maximum Candies Allocated to K Children
 */

import java.util.Scanner;

public class LC2226 {
    public static int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;

        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean canDistribute(int[] candies, long k, int candiesPerChild) {
        long count = 0;
        for (int candy : candies) {
            count += (candy / candiesPerChild);
        }
        return count >= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Candies Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] candies = new int[n];

        System.out.println("Enter The Elements of the Candies Array : ");
        for (int i = 0; i < candies.length; i++) {
            System.out.printf("[%d] : ", i);
            candies[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Integer K : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = maximumCandies(candies, k);

        System.out.println(ans);

        sc.close();
    }
}
