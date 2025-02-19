/*
 * LC1415 - The k-th Lexicographical String of All Happy Strings of Length n
 */

import java.util.*;

public class LC1415 {
    static String result;
    static int count;

    public static String getHappyString(int n, int k) {
        count = 0;
        result = "";
        backTrack(n, k, new StringBuilder(""));
        return result;
    }

    public static boolean backTrack(int n, int k, StringBuilder cur) {
        // base case
        if (cur.length() == n) {
            count++;
            if (count == k) {
                result = cur.toString();
                return true;
            }
            return false;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (cur.length() > 0 && cur.charAt(cur.length() - 1) == ch) {
                continue;
            }
            cur.append(ch);
            if (backTrack(n, k, cur)) {
                return true;
            }
            cur.deleteCharAt(cur.length() - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter The K : ");
        int k = sc.nextInt();
        System.out.println();

        String ans = getHappyString(n, k);

        System.out.println(ans);

        sc.close();
    }
}