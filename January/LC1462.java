/*
 * LC1462 - Course Schedule IV
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC1462 {
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean mat[][] = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int s = prerequisites[i][0];
            int d = prerequisites[i][1];
            mat[s][d] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int s = 0; s < numCourses; s++) {
                for (int d = 0; d < numCourses; d++) {
                    mat[s][d] = mat[s][d] || (mat[s][k] && mat[k][d]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int d = queries[i][1];
            ans.add(mat[s][d]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Num of Course : ");
        int numCourses = sc.nextInt();
        System.out.println();

        System.out.println("Enter Size of the prerequisites Array : ");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] prerequisites = new int[row][col];

        System.out.println("Enter The Elements of the Prerequisites : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                prerequisites[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.println("Enter The Queries Array Size : ");
        System.out.print("Enter Row : ");
        int row2 = sc.nextInt();
        System.out.print("Enter Column : ");
        int col2 = sc.nextInt();
        System.out.println();

        int[][] queries = new int[row2][col2];

        System.out.println("Enter The Queries Array Elements : ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                queries[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        List<Boolean> ans = checkIfPrerequisite(numCourses, prerequisites, queries);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.printf("%d, ", ans.get(i));
        }

        sc.close();
    }
}