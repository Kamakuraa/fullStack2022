package ro.fasttrackit.curs4.curs4.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ranges {
  private final List<Range> ranges = new ArrayList<> ();

  public Ranges(int... values) {
    this.ranges.addAll (buildRanges (values));
  }


  private List<Range> buildRanges(int[] values) {
    if (values == null || values.length == 0) {
      return List.of (new Range (0, Integer.MAX_VALUE));
    }
    List<Integer> intervalValues = Arrays.stream (values)
      .sorted ()
      .filter (val -> val >= 0)
      .boxed ()
      .collect (Collectors.toList ());

    intervalValues.add (0, 0);
    intervalValues.add (Integer.MAX_VALUE);


    List<Integer> finalValues = intervalValues.stream()
      .filter(val -> val >= 0)
      .distinct()
      .sorted()
      .toList();

    return IntStream.range(0, finalValues.size() - 1)
      .mapToObj(index -> new Range(finalValues.get(index), finalValues.get(index + 1)))
      .toList();

//    List<Range> result = new ArrayList<> ();
//    if (intervalValues.get (0) > 0) {
//      result.add (new Range (0, intervalValues.get (0)));
//    }
//
//    for (int i = 0; i < intervalValues.size () - 1; i++) {
//      result.add (new Range (intervalValues.get (i), intervalValues.get (i + 1)));
//    }
//    if (intervalValues.get (intervalValues.size () - 1) != Integer.MAX_VALUE) {
//      result.add (new Range (intervalValues.get (intervalValues.size () - 1), Integer.MAX_VALUE));
//    }
//
//    return result;
  }

  public List<Range> getRanges() {
    return ranges;
  }
  public Range getRange(int value) {
    return ranges.stream ()
      .filter (range -> range.contains(value))
      .findFirst ()
      .orElseGet (()->new Range (0, Integer.MAX_VALUE));
  }
}
