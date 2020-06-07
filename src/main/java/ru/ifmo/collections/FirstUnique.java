package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final Map<Integer, Integer> count;

    public FirstUnique(int[] numbers) {
        count = new LinkedHashMap<>();
        for (var number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        for (var item : count.entrySet()) {
            if (item.getValue().equals(1)) {
                return item.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        count.compute(value, (key, val) -> (val == null) ? 1 : val + 1);
    }
}
