/*
 * LC2381
 */

import java.util.*;

public class LC2381 {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // Forward direction
                arr[shift[0]]++;
                if (shift[1] + 1 < n) {
                    arr[shift[1] + 1]--;
                }
            } else { // Backward direction
                arr[shift[0]]--;
                if (shift[1] + 1 < n) {
                    arr[shift[1] + 1]++;
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i] % 26);
            if (sum < 0) {
                sum += 26;
            }
            char shiftedChar = (char) ('a' + (s.charAt(i) - 'a' + sum) % 26);
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The String Here : ");
        String s = sc.nextLine();
        System.out.println();

        System.out.print("Enter the size of the Shifts Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] shifts = new int[n][n];

        System.out.println("Enter Shifts Array Elements : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                shifts[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        String ans = shiftingLetters(s, shifts);

        System.out.println(ans);

        sc.close();
    }
}