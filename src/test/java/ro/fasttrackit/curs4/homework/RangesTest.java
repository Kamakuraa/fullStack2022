package ro.fasttrackit.curs4.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangesTest {
  @Test
  void test() {
    Ranges ranges = new Ranges ();
    org.assertj.core.api.Assertions.assertThat (ranges.getRanges ())
      .containsExactly (new Range (0, Integer.MAX_VALUE));
  }

  @Test
  @DisplayName("WHEN 1")
  void whenASingleIsGivenThen2Ranges() {
    Ranges ranges = new Ranges (10);
    org.assertj.core.api.Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (0, Integer.MAX_VALUE)
    );
  }

  @Test
  @DisplayName ("When 2")
  void test2Args(){
    Ranges ranges = new Ranges (10, 30);
    org.assertj.core.api.Assertions.assertThat(ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (0, 30),
      new Range (0, Integer.MAX_VALUE)
    );
  }

  @Test
  @DisplayName ("When not")
  void testNotSorted(){
    Ranges ranges = new Ranges ();
    org.assertj.core.api.Assertions.assertThat(ranges.getRanges ()).containsExactly (
      new Range (0, 18),
      new Range (18, 30),
      new Range (30, 100),
      new Range (100, Integer.MAX_VALUE)
    );
  }
  @Test
  @DisplayName ("WHEN ARGS")
  void testContainsZero(){
    Ranges ranges = new Ranges (0, 10, 20);
    org.assertj.core.api.Assertions.assertThat(ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (10, 20),
      new Range (20, Integer.MAX_VALUE)
    );
  }

  @Test
  @DisplayName ("WHEN ARGS")
  void testContainsMAX(){
    Ranges ranges = new Ranges (0, 10, Integer.MAX_VALUE);
    org.assertj.core.api.Assertions.assertThat(ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (10, 20),
      new Range (20, Integer.MAX_VALUE)
    );
  }
}
