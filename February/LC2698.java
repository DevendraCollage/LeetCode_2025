/*
 * LC2698 - Find the Punishment Number of an Integer
 */

import java.util.*;

public class LC2698 {
    public static int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String i2 = Integer.toString(i * i);
            if (isPartition(0, i2, i, 0)) {
                result += (i * i);
            }
        }

        return result;
    }

    public static boolean isPartition(int j, String i2, int target, int curSum) {
        // base case
        if (j == i2.length()) {
            return (curSum == target);
        }
        for (int i = j; i < i2.length(); i++) {
            int val = Integer.parseInt(i2.substring(j, i + 1));
            if (isPartition(i + 1, i2, target, curSum + val)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        int ans = punishmentNumber(n);

        System.out.println(ans);

        sc.close();
    }
}