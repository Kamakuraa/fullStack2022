package ro.fasttrackit.curs3.javaFeature.curs4;

import ro.fasttrackit.homeworkCurs2.ex2.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java12Features {
  public static void main(String[] args) throws IOException {
    filesMismatch ();
    numberFormatting ();
    teeingCollectors ();
    stringMethods();
    instanceOfPattern();

  }

  private static void instanceOfPattern() {

  }

  private static void stringMethods() {
    String row = "Ana";

    System.out.println (row.indent (4));
  }

  private static void teeingCollectors() {
    IntStream range = IntStream.range (1, 10);
    double avg = IntStream.range (1, 100)
      .boxed ()
      .collect (Collectors.teeing (
        Collectors.summingDouble (i -> i),
        Collectors.counting (),
        (sum, count) -> sum / count
      ));

  }

  private static void numberFormatting() {
    NumberFormat format = NumberFormat.getCompactNumberInstance (Locale.US, NumberFormat.Style.LONG);
    System.out.println (format.format (1000000004));
  }

  private static void filesMismatch() throws IOException {
    Path firstFile = Path.of ("fist.txt");

    Files.writeString (firstFile, "content");
    System.out.println (firstFile);
  }
}
