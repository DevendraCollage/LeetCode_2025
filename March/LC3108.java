/*
 * LC3108 - Minimum Cost Walk in Weighted Graph
 */

import java.util.*;

class DSU {
    int rank[];
    int parent[];

    DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (node == parent[node]) {
            return node;
        }

        parent[node] = find(parent[node]); // Path compression
        return parent[node];
    }

    public void union(int node1, int node2) {
        int rootParent1 = find(node1);
        int rootParent2 = find(node2);

        if (rootParent1 == rootParent2) {
            return;
        }

        if (rank[rootParent1] < rank[rootParent2]) {
            parent[rootParent1] = rootParent2;
        } else if (rank[rootParent2] < rank[rootParent1]) {
            parent[rootParent2] = rootParent1;
        } else {
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }
    }
}

public class LC3108 {
    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        int[] compCost = new int[n];
        Arrays.fill(compCost, -1);

        for (int[] edge : edges) {
            int rootParent = dsu.find(edge[0]);
            if (compCost[rootParent] == -1) {
                compCost[rootParent] = edge[2];
            } else {
                compCost[rootParent] &= edge[2]; // Bitwise AND operation
            }
        }

        int n1 = query.length;
        int[] res = new int[n1];

        for (int i = 0; i < n1; i++) {
            int node1 = query[i][0];
            int node2 = query[i][1];

            int rootParent1 = dsu.find(node1);
            int rootParent2 = dsu.find(node2);

            if (rootParent1 != rootParent2) {
                res[i] = -1;
            } else {
                res[i] = compCost[rootParent1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Number N : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.println("Enter The Row and Column of Edges Array : ");
        System.out.print("Enter Row : ");
        int row1 = sc.nextInt();
        System.out.print("Enter Column : ");
        int col1 = sc.nextInt();
        System.out.println();

        int[][] edges = new int[row1][col1];

        System.out.println("Enter The Elements of the Edges : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.println("Enter The Row and Column of Query Array : ");
        System.out.print("Enter Row : ");
        int row2 = sc.nextInt();
        System.out.print("Enter Column : ");
        int col2 = sc.nextInt();
        System.out.println();

        int[][] query = new int[row2][col2];

        System.out.println("Enter The Elements of the Query : ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                query[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[] ans = minimumCost(n, edges, query);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}
