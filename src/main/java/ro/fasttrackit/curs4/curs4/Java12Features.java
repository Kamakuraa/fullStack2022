package ro.fasttrackit.curs4.curs4;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java12Features {
  public static void main(String[] args) {
    teiingCollector ();
    stringTransform ();
    patternMatching ("abcdefghijklmnopqrst");
  }

  private static void patternMatching(Object object) {
    if (object instanceof String) {
      String name = (String) object;
      System.out.println (name.substring (5));
    }

    if (object instanceof String name){
      System.out.println (name.substring (7));
    }
  }

  private static void stringTransform() {
    var trs = "AnaMaria".transform (v -> v.substring (2));
    System.out.println (trs);
  }

  private static void teiingCollector() {
    var average = IntStream.range (1, 100)
      .boxed ()
      .collect (Collectors.teeing (
        Collectors.summingDouble (t -> t),
        Collectors.counting (),
        (sum, count) -> sum / count
      ));
    System.out.println (average);
  }
}
