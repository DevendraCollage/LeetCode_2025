/*
 * LC1769
 */

import java.util.Scanner;

public class LC1769 {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        int count = boxes.charAt(0) - '0';
        // For Left pass
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + count;
            count += boxes.charAt(i) - '0';
        }
        count = boxes.charAt(n - 1) - '0';
        // For Right pass
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += boxes.charAt(i) - '0';
        }
        // For Answer to add
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Boxes : ");
        String boxes = sc.nextLine();
        System.out.println();

        int[] ans = minOperations(boxes);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}