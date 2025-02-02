/*
 * LC827 - Making A Large Island
 */

import java.util.*;

public class LC827 {
    public static int largestIsland(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int maxSize = 0;
        List<Integer> sizes = new ArrayList<>(List.of(0, 0));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sizes.add(paint(grid, i, j, sizes.size())); // Paint with the give color 2, 3 ....
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIds = new HashSet<>(Arrays.asList(getId(grid, i - 1, j), getId(grid, i + 1, j),
                            getId(grid, i, j + 1), getId(grid, i, j - 1)));
                    maxSize = Math.max(maxSize, 1 + getSize(grid, neighborIds, sizes));
                }
            }
        }

        return maxSize == 0 ? m * n : maxSize;
    }

    private static int getSize(int[][] grid, Set<Integer> neighborIds, List<Integer> sizes) {
        int size = 0;
        for (final int neighborId : neighborIds) {
            size += sizes.get(neighborId);
        }
        return size;
    }

    private static int getId(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return 0;
        }

        return grid[i][j];
    }

    private static int paint(int[][] grid, int i, int j, int id) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 1) { // If it not equal to 1 don't visit it
            return 0;
        }
        grid[i][j] = id;
        // Checking the four direction (top, bottom, right, left)
        return 1 + paint(grid, i + 1, j, id) + paint(grid, i - 1, j, id) + paint(grid, i, j + 1, id)
                + paint(grid, i, j - 1, id);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of The Grid Matrix : ");
        System.out.print("Enter N : ");
        int n = sc.nextInt();
        System.out.println();

        int[][] grid = new int[n][n];

        System.out.println("Enter The Grid Elements : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int ans = largestIsland(grid);

        System.out.println(ans);

        sc.close();
    }
}