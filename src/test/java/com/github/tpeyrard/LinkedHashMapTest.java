package com.github.tpeyrard;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class LinkedHashMapTest {

    private static final int EXPECTED_SIZE = 1024;
    private LinkedHashMap map;

    @Before
    public void setUp() {
        map = new LinkedHashMap(EXPECTED_SIZE);
    }

    @Test
    public void
    it_returns_null_when_value_is_absent() {
        assertThat(map.get("Absent")).isNull();
    }

    @Test
    public void
    one_can_put_a_pair_of_String_Integer() {
        map.put("First", 1);

        assertThat(map.get("First")).isEqualTo(1);
    }

    @Test
    public void
    one_can_add_several_pairs() {
        map.put("First", 1);
        map.put("Second", 2);
        map.put("Third", 3);
        map.put("Big", 643646354);

        assertThat(map.get("First")).isEqualTo(1);
        assertThat(map.get("Third")).isEqualTo(3);
        assertThat(map.get("Big")).isEqualTo(643646354);
    }

    @Test
    public void
    it_uses_hash_code_as_hash_function() {
        String key = "aaaa";
        int value = 666;
        map.put(key, value);

        int expectedPosition = Math.abs(key.hashCode()) % EXPECTED_SIZE;

        assertThat(map.values[expectedPosition]).isEqualTo(value);
    }

    @Test
    public void
    it_can_remove_a_value() {
        map.put("First", 1);
        map.put("Second", 2);
        map.put("Big", 643646354);

        map.remove("Big");

        assertThat(map.get("Big")).isNull();
    }

    private String[] keys(String... keys) {
        return keys;
    }
}