/*
 * LC1352 - Product of the Last K Numbers
 */

import java.util.ArrayList;

class ProductOfNumbers {
    private ArrayList<Integer> list;
    private int lastZeroIndex;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        lastZeroIndex = -1;
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            list.add(1);
            lastZeroIndex = list.size() - 1;
        } else {
            int prevProduct = list.get(list.size() - 1);
            list.add(prevProduct * num);
        }
    }

    public int getProduct(int k) {
        int s = list.size();
        if (s <= k || lastZeroIndex >= s - k) {
            return 0;
        }
        return list.get(s - 1) / list.get(s - k - 1);
    }
}