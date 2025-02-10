/*
 * LC3174 - Clear Digits
 */

import java.util.*;

public class LC3174 {
    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String s = sc.nextLine();
        System.out.println();

        String ans = clearDigits(s);

        System.out.println(ans);

        sc.close();
    }
}