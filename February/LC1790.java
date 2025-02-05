/*
 * LC1790 - Check if One String Swap Can Make Strings Equal
 */

import java.util.Scanner;

public class LC1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        int first = -1, second = -1;

        for (int index = 0; index < len; index++) {
            if (s1.charAt(index) != s2.charAt(index)) {
                count++;
                if (count == 1) {
                    first = index;
                } else if (count == 2) {
                    second = index;
                } else {
                    return false;
                }
            }
        }

        if (count == 0) {
            return true; // Strings are already equal
        }

        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The First String Here : ");
        String s1 = sc.nextLine();
        System.out.println();

        System.out.print("Enter The Second String Here : ");
        String s2 = sc.nextLine();
        System.out.println();

        boolean ans = areAlmostEqual(s1, s2);

        System.out.println(ans);

        sc.close();
    }
}
