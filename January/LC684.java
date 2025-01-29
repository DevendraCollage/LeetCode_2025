/*
 * LC684 - Redundant Connection
 */

import java.util.*;

class DisjointSet {
    static int parent[];
    static int size[];

    DisjointSet(int nodes) {
        parent = new int[nodes];
        size = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static int findRootParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public boolean unionBySize(int node1, int node2) {
        // 1 find the root parent
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);
        if (rootParent1 == rootParent2) {
            return false;
        }
        // 2 union of components
        if (size[rootParent1] < size[rootParent2]) {
            parent[rootParent1] = rootParent2;
            size[rootParent2] = size[rootParent1];
        } else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
        return true;
    }
}

public class LC684 {
    static int totalNodes;
    // 1 based graph

    public static int[] findRedundantConnection(int[][] edges) {
        totalNodes = edges.length;
        int[] res = new int[2];
        DisjointSet dsu = new DisjointSet(totalNodes);
        for (int[] edge : edges) {
            if (!dsu.unionBySize(edge[0] - 1, edge[1] - 1)) {
                res = edge;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Size of Edges Array : ");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] edges = new int[row][col];

        System.out.println("Enter The Edges Array Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        int[] ans = findRedundantConnection(edges);

        System.out.println("Answers : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d ", ans[i]);
        }

        sc.close();
    }
}