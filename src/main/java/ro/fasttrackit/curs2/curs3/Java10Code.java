package ro.fasttrackit.curs2.curs3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java10Code {
  public static void main(String[] args) {
    localTypeInference ();
    copyOf();
  }

  private static void copyOf() {
   List<String> name = List.of ("name")
      .stream ()
      .collect(Collectors.toList());

  }

  private static void localTypeInference() {
    int a = 1;
    var b = 2;

    var map = Map.of ("a",
      Map.of ("b", List.of (10)));

    String abc = String.valueOf ("abc");

  }
}
