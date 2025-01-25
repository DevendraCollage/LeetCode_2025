/*
 * LC2948 - Make Lexicographically Smallest Array by Swapping Elements
 */

import java.util.*;

public class LC2948 {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);

        ArrayList<Deque<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> group = new HashMap<>();
        int groupIndex = 0;
        list.add(new LinkedList<>());
        list.get(groupIndex).offer(temp[0]);
        group.put(temp[0], 0);
        for (int i = 1; i < n; i++) {
            if (temp[i] - list.get(groupIndex).peekLast() > limit) {
                groupIndex++;
                list.add(new LinkedList<>());
            }
            group.put(temp[i], groupIndex);
            list.get(groupIndex).offer(temp[i]);
        }

        for (int i = 0; i < n; i++) {
            int gi = group.get(nums[i]);
            nums[i] = list.get(gi).poll();
        }

        return nums;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Array Num Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] num = new int[n];

        System.out.println("Enter The Num Array Elements : ");
        for (int i = 0; i < num.length; i++) {
            System.out.printf("[%d] : ", i);
            num[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The limit : ");
        int limit = sc.nextInt();
        System.out.println();

        int[] ans = lexicographicallySmallestArray(num, limit);

        System.out.println("Answer : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("%d, ", ans[i]);
        }

        sc.close();
    }
}