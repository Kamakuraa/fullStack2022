package ro.fasttrackit.curs4.curs4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.fasttrackit.curs4.curs4.homework.Range;
import ro.fasttrackit.curs4.curs4.homework.Ranges;

import static java.lang.Integer.MAX_VALUE;

class RangesTest {

  @Test
  @DisplayName("WHEN mo args in constructor then a single age is created")
  void whenNoArgsThen1RangeIsReturned() {
    Ranges ranges = new Ranges ();

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN mo args in constructor then [0, n], [n, max]")
  void whenASingleArgIsGivenThen2Ranges() {
    Ranges ranges = new Ranges (10);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (10, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN no args in constructor then [0, n],[n,m], [n, max]")
  void test2Args() {
    Ranges ranges = new Ranges (10, 30);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (10, 30),
      new Range (30, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN not sorted args in constructor THEN the intervals are sorted")
  void testNotSorted() {
    Ranges ranges = new Ranges (30, 18, 100);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 18),
      new Range (18, 30),
      new Range (30, 100),
      new Range (100, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN args contains 0 THEN extra interval is added in front")
  void testContainsZero() {
    Ranges ranges = new Ranges (0, 10, 20);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 10),
      new Range (10, 20),
      new Range (20, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN args contains MAX THEN no extra interval is added in end")
  void testContainsMAX() {
    Ranges ranges = new Ranges (7, 10, 20, MAX_VALUE);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 7),
      new Range (7, 10),
      new Range (10, 20),
      new Range (20, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN args contains MAX THEN we ignore them")
  void testNegativ() {
    Ranges ranges = new Ranges ( 7, 10, 20, MAX_VALUE);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (0, 7),
      new Range (7, 10),
      new Range (10, 20),
      new Range (20, MAX_VALUE)
    );
  }

  @Test
  @DisplayName("WHEN args contains MAX THEN we dont duplicate")
  void testDuplicatesValues() {
    Ranges ranges = new Ranges (-10, 7, 10, 10, 20, MAX_VALUE);

    Assertions.assertThat (ranges.getRanges ()).containsExactly (
      new Range (-10, 7),
      new Range (7, 10),
      new Range (10, 20),
      new Range (20, MAX_VALUE)
    );
  }
}
