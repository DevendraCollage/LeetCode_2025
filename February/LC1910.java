/*
 * LC1910 - Remove All Occurrences of a Substring
 */

import java.util.*;

public class LC1910 {
    public static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int m = part.length();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            if (sb.length() >= m) {
                String sub = sb.substring(sb.length() - m);
                if (sub.equals(part)) {
                    sb.setLength(sb.length() - m);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The First String : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter The String Part : ");
        String part = sc.nextLine();
        System.out.println();

        String ans = removeOccurrences(s, part);

        System.out.println(ans);

        sc.close();
    }
}