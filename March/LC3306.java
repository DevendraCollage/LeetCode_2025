/*
 * LC3306 - Count of Substrings Containing Every Vowel and K Consonants II
 */

import java.util.Scanner;

public class LC3306 {
    public static long countOfSubstrings(String word, int k) {
        return atleast(k, word) - atleast(k + 1, word);
    }

    private static boolean isConsonant(char ch) {
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }

    private static boolean isAllVowelsPresent(int freq[]) {
        return (freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0
                && freq['u' - 'a'] > 0);
    }

    public static long atleast(int k, String words) {
        long count = 0;
        int curConsonant = 0;
        int freq[] = new int[26];
        int n = words.length();
        int left = 0;
        for (int i = 0; i < n; i++) {
            char ch = words.charAt(i);
            if (isConsonant(ch)) {
                curConsonant++;
            }
            freq[ch - 'a']++;

            while (curConsonant >= k && isAllVowelsPresent(freq)) {
                count += (n - i);

                char c = words.charAt(left);
                if (isConsonant(c)) {
                    curConsonant--;
                }

                freq[c - 'a']--;
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Word : ");
        String word = sc.nextLine();
        System.out.println();

        System.out.print("Enter The Value K : ");
        int k = sc.nextInt();
        System.out.println();

        long ans = countOfSubstrings(word, k);

        System.out.println(ans);

        sc.close();
    }
}
