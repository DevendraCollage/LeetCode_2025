/*
 * LC2349 - Design a Number Container System
 */

import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers {
    static HashMap<Integer, TreeSet<Integer>> numberToIdx;
    static HashMap<Integer, Integer> idxToNumber;

    public NumberContainers() {
        numberToIdx = new HashMap<>();
        idxToNumber = new HashMap<>();
    }

    public static void change(int index, int number) {
        // Delete old
        if (idxToNumber.containsKey(index)) {
            int prev = idxToNumber.get(index);
            numberToIdx.get(prev).remove(index);
            if (numberToIdx.get(prev).size() == 0) {
                numberToIdx.remove(prev);
            }
        }

        // Insert new
        idxToNumber.put(index, number);
        if (!numberToIdx.containsKey(number)) {
            numberToIdx.put(number, new TreeSet<>());
        }
        numberToIdx.get(number).add(index);
    }

    public static int find(int number) {
        if (!numberToIdx.containsKey(number)) {
            return -1;
        }

        return numberToIdx.get(number).first();
    }
}