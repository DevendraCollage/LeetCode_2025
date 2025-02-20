/*
 * LC1980 - Find Unique Binary String
 */

import java.util.HashSet;
import java.util.Scanner;

public class LC1980 {
    static StringBuilder res;

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        res = new StringBuilder("");
        backTrack(nums, n, set, res);
        return res.toString();
    }

    public static boolean backTrack(String[] nums, int n, HashSet<String> set, StringBuilder res) {
        // base case
        if (res.length() == n) {
            if (!set.contains(res.toString())) {
                return true;
            }
            return false;
        }
        for (char ch = '0'; ch <= '1'; ch++) {
            res.append(ch);
            if (backTrack(nums, n, set, res)) {
                return true;
            }
            res.deleteCharAt(res.length() - 1);
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        String[] nums = new String[n];
        sc.nextLine();

        System.out.println("Enter The Nums String Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextLine();
        }
        System.out.println();

        String ans = findDifferentBinaryString(nums);

        System.out.println(ans);

        sc.close();
    }
}