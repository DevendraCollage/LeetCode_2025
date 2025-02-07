/*
 * LC3160 - Find the Number of Distinct Colors Among the Balls
 */

import java.util.HashMap;
import java.util.Scanner;

public class LC3160 {
    public static int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (!ballMap.containsKey(ball)) {
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            } else {
                int oldColor = ballMap.get(ball);
                colorMap.put(oldColor, colorMap.get(oldColor) - 1);
                if (colorMap.get(oldColor) == 0) {
                    colorMap.remove(oldColor);
                }
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            }
            res[i] = colorMap.size();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Limit : ");
        int limit = sc.nextInt();
        System.out.println();

        System.out.println("Enter The Queries Array Length : ");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] queries = new int[row][col];

        System.out.println("Enter The Queries Array Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                queries[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[] ans = queryResults(limit, queries);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}