/*
 * LC2579 - Count Total Number of Colored Cells
 */

import java.util.*;

public class LC2579 {
    public static long coloredCells(int n) {
        long res = n;
        return 1 + (res - 1) * res * 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Number N : ");
        int n = sc.nextInt();
        System.out.println();

        long ans = coloredCells(n);

        System.out.println(ans);

        sc.close();
    }
}