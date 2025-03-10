/*
 * LC3208 - Alternating Groups II
 */

import java.util.*;

public class LC3208 {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int left = 0;
        int n = colors.length;
        for (int i = 1; i < (n + k - 1); i++) {
            // skip entire subarray
            if (colors[i % n] == colors[(i - 1) % n]) {
                left = i;
            }
            if (i - left + 1 == k) {
                res++;
                left++; // move to next subarray or shrinking phase
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size of Colors Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] colors = new int[n];

        System.out.println("Enter The Colors Array Elements : ");
        for (int i = 0; i < colors.length; i++) {
            System.out.printf("[%d] : ", i);
            colors[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Number K : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = numberOfAlternatingGroups(colors, k);

        System.out.println(ans);

        sc.close();
    }
}