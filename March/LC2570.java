/*
 * LC2570 - Merge Two 2D Arrays by Summing Values
 */

import java.util.*;

public class LC2570 {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> res = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                res.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res.add(new int[] { nums1[i][0], nums1[i][1] });
                i++;
            } else {
                res.add(new int[] { nums1[j][0], nums2[j][1] });
                j++;
            }
        }

        while (i < n) {
            res.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }

        while (j < m) {
            res.add(new int[] { nums1[j][0], nums2[j][1] });
            j++;
        }

        int len = res.size();
        int[][] result = new int[len][2];

        for (int k = 0; k < len; k++) {
            result[k] = res.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Nums1 2D Array Size : ");
        System.out.print("Enter Row : ");
        int row1 = sc.nextInt();
        System.out.print("Enter Column : ");
        int col1 = sc.nextInt();
        System.out.println();

        int[][] nums1 = new int[row1][col1];

        System.out.println("Enter The Nums1 Array Elements : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                nums1[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.println("Enter The Nums2 2D Array Size : ");
        System.out.print("Enter Row : ");
        int row2 = sc.nextInt();
        System.out.print("Enter Column : ");
        int col2 = sc.nextInt();
        System.out.println();

        int[][] nums2 = new int[row2][col2];

        System.out.println("Enter The Nums2 Array Elements : ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                nums2[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[][] ans = mergeArrays(nums1, nums2);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.printf("%d\t", ans[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}