/*
 * LC1780 - Check if Number is a Sum of Powers of Three
 */

import java.util.*;

public class LC1780 {
    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if ((n % 3) == 2) {
                return false;
            }
            n /= 3;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Number N : ");
        int n = sc.nextInt();
        System.out.println();

        boolean ans = checkPowersOfThree(n);

        System.out.println(ans);

        sc.close();
    }
}