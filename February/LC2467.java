/*
 * LC2467 - Most Profitable Path in a Tree
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC2467 {
    private List<Integer>[] g;
    private int[] amount;
    private int[] ts;
    private int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        g = new List[n];
        ts = new int[n];
        this.amount = amount;
        Arrays.setAll(g, k -> new ArrayList<>());
        Arrays.fill(ts, n);
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs1(bob, -1, 0);
        ts[bob] = 0;
        dfs2(0, -1, 0, 0);
        return ans;
    }

    private boolean dfs1(int i, int fa, int t) {
        if (i == 0) {
            ts[i] = Math.min(ts[i], t);
            return true;
        }
        for (int j : g[i]) {
            if (j != fa && dfs1(j, i, t + 1)) {
                ts[j] = Math.min(ts[j], t + 1);
                return true;
            }
        }
        return false;
    }

    private void dfs2(int i, int fa, int t, int v) {
        if (t == ts[i]) {
            v += amount[i] >> 1;
        } else if (t < ts[i]) {
            v += amount[i];
        }
        if (g[i].size() == 1 && g[i].get(0) == fa) {
            ans = Math.max(ans, v);
            return;
        }
        for (int j : g[i]) {
            if (j != fa) {
                dfs2(j, i, t + 1, v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Edges Array Row and Column");
        System.out.print("Enter The Row : ");
        int row = sc.nextInt();
        System.out.print("Enter The Column : ");
        int col = sc.nextInt();

        int[][] edges = new int[row][col];

        System.out.println("Enter The Edges Array Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                edges[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        System.out.println("Enter The Bob Value : ");
        int bob = sc.nextInt();
        System.out.println();

        System.out.print("Enter The Size of Amount Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] amount = new int[n];

        System.out.println("Enter The Amount Array Elements : ");
        for (int i = 0; i < amount.length; i++) {
            System.out.printf("[%d] : ", i);
            amount[i] = sc.nextInt();
        }
        System.out.println();

        int ans = mostProfitablePath(edges, bob, amount);

        System.out.println(ans);

        sc.close();
    }
}
