package com.github.tpeyrard.algo;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MergeSortTest {


    @Test
    public void
    it_sorts() {
        assertThat(MergeSort.sort(arrayOf(38, 27, 43, 3, 9, 82, 10)))
                .isEqualTo(arrayOf(3, 9, 10, 27, 38, 43, 82));
    }

    private int[] arrayOf(int... values) {
        return values;
    }
}