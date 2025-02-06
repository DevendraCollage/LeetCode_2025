/*
 * LC1726 - Tuple with Same Product
 */

import java.util.*;

public class LC1726 {
    public static int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // products pair
                int res = nums[i] * nums[j];
                productMap.put(res, productMap.getOrDefault(res, 0) + 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : productMap.entrySet()) {
            int count = entry.getValue();
            if (count >= 2) {
                int comb = (count * (count - 1)) / 2;
                ans = ans + comb * 8;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size of The Nums Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] nums = new int[n];

        System.out.println("Enter The Nums Array Elements : ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("[%d] : ", i);
            nums[i] = sc.nextInt();
        }
        System.out.println();

        int ans = tupleSameProduct(nums);

        System.out.println(ans);

        sc.close();
    }
}