/*
 * LC2523 - Closest Prime Numbers in Range
 */

import java.util.*;

public class LC2523 {
    public static int[] closestPrimes(int left, int right) {
        // Sieve algorithm to find prime numbers between [1, right]
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    prime[j] = false;
                }
            }
        }

        // find min diff b/w pair of prime numbers
        int[] res = new int[] { -1, -1 };
        int minDiff = Integer.MAX_VALUE;
        int prev = -1;
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (prev == -1) {
                    prev = i;
                } else {
                    if (i - prev < minDiff) {
                        res[0] = prev;
                        res[1] = i;
                        minDiff = i - prev;
                    }
                    prev = i;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Left Value : ");
        int left = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Right Value : ");
        int right = sc.nextInt();
        System.out.println();

        int[] ans = closestPrimes(left, right);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}