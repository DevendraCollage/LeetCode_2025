/*
 * LC2493 - Divide Nodes Into the Maximum Number of Groups
 */

import java.util.*;

public class LC2493 {
    public static int magnificentSets(int n, int[][] edges) {
        // Form an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // 1 to n => 0 => n-1
        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        // bipartite graph
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }
            colors[i] = 1;
            if (!isBipartite(adjList, i, colors)) {
                return -1;
            }

        }
        int[] distance = new int[n];
        for (int j = 0; j < n; j++) {
            distance[j] = getLongestLength(adjList, j, n);
        }

        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int j = 0; j < n; j++) {
            if (visited[j]) {
                continue;
            }
            maxNumberOfGroups += getNumberOfGroupsForComponent(adjList, j, distance, visited);
        }

        return maxNumberOfGroups;
    }

    // Calculate the maximum number of groups for a connected component
    private static int getNumberOfGroupsForComponent(ArrayList<ArrayList<Integer>> adjList, int node, int[] distance,
            boolean[] visited) {
        // Start with the distance of the current node as the maximum
        int maxNumberOfGroups = distance[node];
        visited[node] = true;

        // Recursively calculate the maximum for all unvisited neighbors
        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor]) {
                continue;
            }
            maxNumberOfGroups = Math.max(maxNumberOfGroups,
                    getNumberOfGroupsForComponent(adjList, neighbor, distance, visited));
        }
        return maxNumberOfGroups;
    }

    // Perform only BFS (Breadth First Search)
    private static int getLongestLength(ArrayList<ArrayList<Integer>> adjList, int srcNode, int n) {
        Queue<Integer> nodesQueue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        nodesQueue.add(srcNode);
        visited[srcNode] = true;
        int distance = 0;

        while (!nodesQueue.isEmpty()) {
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) {
                        continue;
                    }
                    visited[neighbor] = true;
                    nodesQueue.add(neighbor);
                }
            }
            distance++;
        }

        return distance;
    }

    // Checks if the graph is bipartite
    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int node, int[] colors) {
        for (int neighbor : adjList.get(node)) {
            if (colors[neighbor] == colors[node]) { // Check for same color
                return false;
            }
            if (colors[neighbor] != 0) { // Already colored
                continue;
            }
            colors[neighbor] = -1 * (colors[node]); // not visited -> color
            if (!isBipartite(adjList, neighbor, colors)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The N : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.println("Enter The Edges Array Size : ");
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

        int ans = magnificentSets(n, edges);

        System.out.println(ans);

        sc.close();
    }
}