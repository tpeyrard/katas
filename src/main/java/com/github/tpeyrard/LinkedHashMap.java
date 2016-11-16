package com.github.tpeyrard;

import java.util.ArrayList;
import java.util.List;

public class LinkedHashMap {
    private final int expectedSize;
    Integer[] values;
    List<String> keys;

    public LinkedHashMap(int expectedSize) {
        this.expectedSize = expectedSize;
        this.values = new Integer[this.expectedSize];
        this.keys = new ArrayList<>(this.expectedSize);
    }

    public Integer get(String key) {
        assert key != null;
        int position = hash(key);
        return values[position] == null ? null : values[position];
    }

    public void put(String key, Integer value) {
        int position = hash(key);
        values[position] = value;
        keys.add(key);
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % expectedSize;
    }

    public void remove(String keyToRemove) {
        values[hash(keyToRemove)] = null;
        keys.remove(keyToRemove);
    }
}
