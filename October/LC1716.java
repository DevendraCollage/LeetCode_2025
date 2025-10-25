class Solution {
    public int totalMoney(int n) {
        int k = n / 7;
        int F = 28;
        int L = 28 + (k - 1) * 7;
        int arithmeticSum = k * (F + L) / 2;

        int monday = k + 1;
        int finalWeek = 0;

        for (int i = 0; i < n % 7; i++) {
            finalWeek += monday + i;
        }

        return arithmeticSum + finalWeek;
    }
}