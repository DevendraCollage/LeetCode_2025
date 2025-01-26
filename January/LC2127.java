/*
 * LC2127 - Maximum Employees to Be Invited to a Meeting
 */

import java.util.*;

public class LC2127 {
    public static int maximumInvitations(int[] favorite) {
        // find complete cycles
        int n = favorite.length;
        int longestCycle = 0;
        boolean vis[] = new boolean[n];
        ArrayList<int[]> twoLenCycles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            int start = i;
            int cur = i;
            while (!vis[cur]) {
                vis[cur] = true;
                set.add(cur);
                cur = favorite[cur];
            }
            int len = set.size();
            while (start != cur) {
                len--;
                start = favorite[start];
            }
            longestCycle = Math.max(longestCycle, len);
            if (len == 2) {
                twoLenCycles.add(new int[] { cur, favorite[cur] });
            }
        }

        // Find 2 length cycles (add if possible)
        List<List<Integer>> reverseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            reverseList.get(favorite[i]).add(i);
        }
        int max2LenCyclePath = 0;
        for (int arr[] : twoLenCycles) {
            max2LenCyclePath += f(arr[0], arr[1], reverseList) + f(arr[1], arr[0], reverseList) + 2;
        }
        // Return max
        return Math.max(max2LenCyclePath, longestCycle);
    }

    public static int f(int node, int skip, List<List<Integer>> reverseList) {
        int len = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { node, 0 });
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            len = Math.max(len, cur[1]);
            for (int neighbor : reverseList.get(cur[0])) {
                if (neighbor == skip) {
                    continue;
                }
                queue.offer(new int[] { neighbor, cur[1] + 1 });
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Favorite Person Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] favorite = new int[n];

        System.out.println("Enter The Favorite Array Elements : ");
        for (int i = 0; i < favorite.length; i++) {
            System.out.printf("[%d] : ", i);
            favorite[i] = sc.nextInt();
        }
        System.out.println();

        int ans = maximumInvitations(favorite);

        System.out.println(ans);

        sc.close();
    }
}