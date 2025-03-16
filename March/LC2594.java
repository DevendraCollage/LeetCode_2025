/*
 * LC2594 - Minimum Time to Repair Cars
 */

import java.util.*;

public class LC2594 {
    public static long repairCars(int[] ranks, int cars) {
        long start = Long.MAX_VALUE;
        long end = Long.MIN_VALUE;
        for (int rank : ranks) {
            end = Math.max(end, rank);
            start = Math.min(start, rank);
        }
        end = end * cars * cars;
        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isCarsRepaired(mid, ranks, cars)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isCarsRepaired(long time, int[] ranks, int carsToBeRepaired) {
        long carsRepaired = 0;
        for (int rank : ranks) {
            carsRepaired += (long) (Math.sqrt((1.0 * time) / rank));
            if (carsRepaired >= carsToBeRepaired) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size of the Ranks Array : ");
        int n = sc.nextInt();
        System.out.println();

        int[] ranks = new int[n];

        System.out.println("Enter The Ranks Array Elements : ");
        for (int i = 0; i < ranks.length; i++) {
            System.out.printf("[%d] : ", i);
            ranks[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter The Cars Number : ");
        int cars = sc.nextInt();
        System.out.println();

        long ans = repairCars(ranks, cars);

        System.out.println(ans);

        sc.close();
    }
}