package com.github.tpeyrard;

public class LinkedHashMap {
    private final int expectedSize;
    Integer[] values;

    public LinkedHashMap(int expectedSize) {
        this.expectedSize = expectedSize;
        this.values = new Integer[this.expectedSize];
    }

    public Integer get(String key) {
        assert key != null;
        int position = hash(key);
        return values[position] == null ? null : values[position];
    }

    public void put(String key, Integer value) {
        int position = hash(key);
        values[position] = value;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % expectedSize;
    }

    public void remove(String keyToRemove) {
        values[hash(keyToRemove)] = null;
    }
}
