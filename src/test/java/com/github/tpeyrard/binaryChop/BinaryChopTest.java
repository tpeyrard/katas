package com.github.tpeyrard.binaryChop;

import static com.github.tpeyrard.binaryChop.BinaryChop.chop;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class BinaryChopTest {

   @Ignore
   @Test
   public void
   acceptance_test() {
      assertThat(0).isEqualTo(chop(1, 1, 3, 5));
      assertThat(1).isEqualTo(chop(3, 1, 3, 5));
      assertThat(2).isEqualTo(chop(5, 1, 3, 5));
      assertThat(0).isEqualTo(chop(1, 1));
      assertThat(0).isEqualTo(chop(1, 1, 3, 5, 7));
      assertThat(1).isEqualTo(chop(3, 1, 3, 5, 7));
      assertThat(2).isEqualTo(chop(5, 1, 3, 5, 7));
      assertThat(3).isEqualTo(chop(7, 1, 3, 5, 7));
      assertThat(-1).as("Empty array").isEqualTo(chop(3));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(3, 1));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(0, 1, 3, 5));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(2, 1, 3, 5));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(4, 1, 3, 5));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(6, 1, 3, 5));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(0, 1, 3, 5, 7));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(2, 1, 3, 5, 7));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(4, 1, 3, 5, 7));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(6, 1, 3, 5, 7));
      assertThat(-1).as("Element not in the array").isEqualTo(chop(8, 1, 3, 5, 7));
   }
}