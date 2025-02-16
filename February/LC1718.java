/*
 * LC1718 - Construct the Lexicographically Largest Valid Sequence
 */

import java.util.*;

public class LC1718 {
    public static int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[n + 1];
        int[] seq = new int[2 * n - 1];
        backTrack(0, used, seq, n);
        return seq;
    }

    public static boolean backTrack(int index, boolean used[], int seq[], int target) {
        while (index < seq.length && seq[index] != 0) {
            index++;
        }
        if (index == seq.length) {
            return true;
        }
        for (int i = target; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1) { // Place 1 at the current index
                seq[index] = i;
                used[i] = true;
                if (backTrack(index + 1, used, seq, target)) {
                    return true;
                }
                seq[index] = 0;
                used[i] = false;
            } else if (index + i < seq.length && seq[index + i] == 0) {
                seq[index] = i;
                seq[index + i] = i;
                used[i] = true;
                if (backTrack(index + 1, used, seq, target)) {
                    return true;
                }
                // Backtracking
                seq[index] = 0;
                seq[index + i] = 0;
                used[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        int[] ans = constructDistancedSequence(n);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}