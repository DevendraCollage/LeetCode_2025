/*
 * LC2375 - Construct Smallest Number From DI String
 */

import java.util.*;

public class LC2375 {
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        boolean[] used = new boolean[10];
        int[] num = new int[n + 1];
        StringBuilder result = new StringBuilder();

        backTrack(pattern, 0, num, used, result);
        return result.toString();
    }

    private static boolean backTrack(String pattern, int index, int[] num, boolean[] used, StringBuilder result) {
        // Base case
        if (index == pattern.length() + 1) {
            for (int i = 0; i < num.length; i++) {
                result.append(num[i]);
            }
            return true; // Found the lexicographically smallest valid number
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i] && (index == 0 || isValid(num[index - 1], i, pattern.charAt(index - 1)))) {
                used[i] = true;
                num[index] = i;
                if (backTrack(pattern, index + 1, num, used, result)) {
                    return true;
                }
                num[index] = 0; // Backtrack
                used[i] = false;
            }
        }

        return false;
    }

    private static boolean isValid(int lastDigit, int currentDigit, char condition) {
        return (condition == 'I' && lastDigit < currentDigit) || (condition == 'D' && lastDigit > currentDigit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Pattern String Here : ");
        String pattern = sc.nextLine();
        System.out.println();

        String ans = smallestNumber(pattern);

        System.out.println(ans);

        sc.close();
    }
}