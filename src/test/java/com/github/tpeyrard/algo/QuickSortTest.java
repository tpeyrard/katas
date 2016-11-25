package com.github.tpeyrard.algo;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class QuickSortTest {

    @Test
    public void
    it_sorts() {
        assertThat(QuickSort.sort(arrayOf(38, 27, 43, 3, 9, 82, 10)))
                .isEqualTo(arrayOf(3, 9, 10, 27, 38, 43, 82));
    }

    @Test
    public void
    it_sorts_wikipedia_example() {
        assertThat(QuickSort.sort(arrayOf(3, 7, 8, 5, 2, 1, 9, 5, 4)))
                .isEqualTo(arrayOf(1, 2, 3, 4, 5, 5, 7, 8, 9));
    }

    private int[] arrayOf(int... values) {
        return values;
    }
}