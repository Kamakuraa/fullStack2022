package ro.fasttrackit.curs4.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ranges {
  private final List<Range> ranges = new ArrayList<> ();

  public Ranges(int... values) {
    this.ranges.addAll (buildRanges (values));

  }

  public List<Range> getRanges() {
    return ranges;
  }

  private List<Range> buildRanges(int[] values) {
    if (values == null || values.length == 0) {
      return List.of (new Range (0, Integer.MAX_VALUE));
    }

    List<Integer> intervalValues = Arrays.stream (values)
      .sorted ()
      .distinct ()
      .filter (value -> value >= 0)
      .boxed ()
      .collect (Collectors.toList ());

    intervalValues.add (0, 0);
    intervalValues.add (Integer.MAX_VALUE);
    intervalValues = intervalValues.stream ()
      .distinct ()
      .toList ();

    List<Integer> finalValues = intervalValues.stream ()
      .distinct ()
      .toList ();

    IntStream.range (0, finalValues.size () - 1)
      .mapToObj (index -> new Range (finalValues.get (index), finalValues.get (index + 1)))
      .toList ();


    List<Range> result = new ArrayList<> ();
//
//    if (intervalValues.get (0) > 0) {
//      result.add (new Range (0, values[0]));
//    }
//    for (int i = 0; i < values.length - 1; i++) {
//      result.add (new Range (values[i], values[i + 1]));
//    }
//    if (intervalValues.get (intervalValues.size () - 1) != Integer.MAX_VALUE) {
//      result.add (new Range (values[values.length - 1], Integer.MAX_VALUE));
//
////    }
    return result;
  }

}
