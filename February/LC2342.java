/*
 * LC2342 - Max Sum of a Pair With Equal Sum of Digits
 */

import java.util.HashMap;
import java.util.Scanner;

public class LC2342 {
    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map.containsKey(digitSum)) {
                int prevNum = map.get(digitSum);
                ans = Math.max(prevNum + num, ans);
                map.put(digitSum, Math.max(prevNum, num));
            } else {
                map.put(digitSum, num);
            }

        }

        return ans;
    }

    public static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Nums Array Size : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        int ans = maximumSum(nums);

        System.out.println(ans);

        sc.close();
    }
}