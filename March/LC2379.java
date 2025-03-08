/*
 * LC2379 - Minimum Recolors to Get K Consecutive Black Blocks
 */

import java.util.*;

public class LC2379 {
    public static int minimumRecolors(String blocks, int k) {
        // first window
        int w = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                w++;
            }
        }
        int n = blocks.length();
        int res = w;
        // next window
        for (int j = 1; j < (n - k + 1); j++) {
            if (blocks.charAt(j - 1) == 'W') {
                w--;
            }
            if (blocks.charAt(j + k - 1) == 'W') {
                w++;
            }
            res = Math.min(res, w);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Blocks : ");
        String blocks = sc.nextLine();
        System.out.println();

        System.out.print("Enter The K : ");
        int k = sc.nextInt();
        System.out.println();

        int ans = minimumRecolors(blocks, k);

        System.out.println(ans);

        sc.close();
    }
}