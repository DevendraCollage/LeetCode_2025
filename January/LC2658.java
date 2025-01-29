/*
 * LC2658 - Maximum Number of Fish in a Grid
 */

import java.util.Scanner;

public class LC2658 {
    static int rows;
    static int cols;

    public static int dfs(int r, int c, int grid[][]) {
        // Will check the base case, out of the scope, land cell -> 0, visited -> 0
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        int ans = grid[r][c];
        grid[r][c] = 0;
        ans += dfs(r - 1, c, grid) + dfs(r, c + 1, grid) + dfs(r + 1, c, grid) + dfs(r, c - 1, grid);

        return ans;
    }

    public static int findMaxFish(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxFishes = 0;

        // find max of all components
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    maxFishes = Math.max(maxFishes, dfs(i, j, grid));
                }
            }
        }

        return maxFishes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Size of Grid : ");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] grid = new int[row][col];

        System.out.println("Enter The Grid Array Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = findMaxFish(grid);

        System.out.println("Answer : " + ans);

        sc.close();
    }
}
