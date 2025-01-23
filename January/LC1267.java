/*
 * LC1267 - Count Servers that Communicate
 */

import java.util.Scanner;

public class LC1267 {
    public static int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // remove unreachable service
                    if (rowCount[i] == 1 && colCount[j] == 1) {
                        count--;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Grid Size : ");
        System.out.print("Enter Row : ");
        int m = sc.nextInt();
        System.out.print("Enter Column : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] grid = new int[m][n];

        System.out.println("Enter The Grid Elements : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = countServers(grid);

        System.out.println("Answer : " + ans);

        sc.close();
    }
}