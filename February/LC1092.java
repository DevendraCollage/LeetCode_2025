/*
 * LC1092 - Shortest Common Supersequence 
 */

import java.util.Scanner;

public class LC1092 {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = longestCommonSubSequence(str1, str2);
        int n = dp.length;
        int m = dp[0].length;
        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();

        // Build the SCS using DP table
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // LCS character
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    public static int[][] longestCommonSubSequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }s

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String-1 : ");
        String str1 = sc.nextLine();
        System.out.println();

        System.out.print("Enter The String-2 : ");
        String str2 = sc.nextLine();
        System.out.println();

        String ans = shortestCommonSupersequence(str1, str2);

        System.out.println(ans);

        sc.close();
    }
}
