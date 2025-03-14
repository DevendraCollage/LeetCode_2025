/*
 * LC1358 - Number of Substrings Containing All Three Characters
 */

import java.util.Scanner;

public class LC1358 {
    public static int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int count = 0;
        int currCount = 0;
        int left = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] == 1) {
                currCount++;
            }
            while (currCount == 3) {
                count += (n - i);
                char c = s.charAt(left);
                freq[c - 'a']--;
                if (freq[c - 'a'] == 0) {
                    currCount--;
                }
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String s = sc.nextLine();
        System.out.println();

        int ans = numberOfSubstrings(s);

        System.out.println(ans);

        sc.close();
    }
}