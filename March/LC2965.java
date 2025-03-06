/*
 * LC2965 - Find Missing and Repeated Values
 */

import java.util.Scanner;
import java.util.*;

public class LC2965 {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int n = grid.length;
        int sq = n * n;
        // 1, sq
        int ans[] = new int[2];
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(grid[i][j])) {
                    ans[0] = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                    curSum += grid[i][j];
                }
            }
        }

        int totalSum = sq * (sq + 1) / 2;
        ans[1] = totalSum - curSum;

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Size of The Grid");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] grid = new int[row][col];

        System.out.println("Enter The Grid Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[] ans = findMissingAndRepeatedValues(grid);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}
