/*
 * LC802 - Find Eventual Safe States
 */

import java.util.*;

public class LC802 {
    public static boolean dfs(int node, int[][] graph, HashMap<Integer, Boolean> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        map.put(node, false);

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, map)) {
                return false;
            }
        }

        map.put(node, true);
        return true;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int n = graph.length;
        List<Integer> result = new ArrayList<>();

        // Check all nodes in the graph
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, map)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Graph Size : ");
        System.out.print("Enter Row : ");
        int row = sc.nextInt();
        System.out.print("Enter Column : ");
        int col = sc.nextInt();
        System.out.println();

        int[][] graph = new int[row][col];

        System.out.println("Enter The Graph Elements : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%d][%d] : ", i, j);
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println();

        List<Integer> ans = eventualSafeNodes(graph);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.printf("%d, ", ans.get(i));
        }

        sc.close();
    }
}