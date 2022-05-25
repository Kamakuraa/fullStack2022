package ro.fasttrackit.curs2.curs3;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Code {
  public static void main(String[] args) {
    lambdas (); //implementare anonima a unei interfete functionale
    streams ();
    optional ();
    methodRefs ();
    forEachCollections ();
    timeApi();
  }

  private static void timeApi() {
    LocalDate date = LocalDate.now ();
    LocalDateTime dateTime = LocalDateTime.now ();
    new Date (dateTime.toInstant (ZoneOffset.UTC).toEpochMilli ());
    System.out.println (Optional.of (dateTime)
      .map (dt -> dt.toInstant (ZoneOffset.UTC))
      .map (Instant::toEpochMilli)
      .map (Date::new));
  }

  private static void forEachCollections() {
    List.of ("abc").forEach (System.out::println);
    Map.of ("a", "c", "d", "e").forEach (Java8Code::printEntry);
    Map.ofEntries (
      Map.entry ("key", "value")
    );
  }

  private static void printEntry(String value, String key) {
    System.out.println (value + ":" + key);
  }

  private static void methodRefs() {
    List<Integer> collect = names ().stream ()
      .map (Java8Code::toLength)
      .collect (Collectors.toList ());
  }

  private static int toLength(String s) {
    return s.length ();
  }

  private static void optional() {
    Optional<String> ana = names ().stream ()
      .filter (name -> name.equalsIgnoreCase ("Ana Corina"))
      .map (name -> "Ani Cori")
      .findFirst ();
    System.out.println ("---------------");
    ana.ifPresent (System.out::println);
    String name = ana.orElse ("Ioan");
    System.out.println (name);
    if (ana.isPresent ()) {
      ana.get ();
    }

    ana.orElseGet (() -> heavyProcesing ());
    String result = names ().stream ()
      .filter (n -> n.startsWith ("R"))
      .findFirst ()
      .orElse (heavyProcesing ());

    String resultGet = names ().stream ()
      .filter (n -> n.startsWith ("R"))
      .findFirst ()
      .orElseGet (() -> heavyProcesing ());
    System.out.println (result);
    System.out.println (resultGet);
  }

  private static String heavyProcesing() {
    System.out.println ("heavy procesing");
    return "Ioan";
  }

  private static void streams() {
    System.out.println (names ().stream ()
      .filter (name -> name.length () < 10)
      .count ());

    names ().stream ()
      .filter (names -> names.length () < 10)
      .map (Java8Code::abbreviateName)
      .forEach (System.out::println);
    Map<Character, List<String>> byFirstLetter = names ().stream ().parallel ()
      .peek (n -> System.out.println (Thread.currentThread ().getName ()))
      .collect (Collectors.groupingBy (n -> n.charAt (0)));

    System.out.println (byFirstLetter);

    Map.of ("key", "value")
      .forEach ((key, value) -> System.out.println ("key: " + key + " = " + value));
  }

  private static String abbreviateName(String name) {
    String[] parts = name.split (" ");
    return parts[0] + " " + parts[1].charAt (0) + ".";
  }


  private static List<String> names() {
    return List.of ("Isabell Bushman",
      "Wendolyn Roiger",
      "Magaret Demyan",
      "Corene Strang",
      "Marcie Fausnaught",
      "Valerie Maselli",
      "Terresa Ritenour",
      "Tamra Theiss",
      "Tyler Knicely",
      "Shenita Kerner",
      "Foster Keeney",
      "Nina Mulhall",
      "Reginia Peralto",
      "Daria Obando",
      "Sona Poff",
      "Gema Mink",
      "Delbert Kamp",
      "Tandra Wuensche",
      "Terrell Boelter",
      "Kyle Bassi");
  }

  private static void lambdas() {
    MyInterfaces b = name -> "salut" + name;
    System.out.println (b);
  }
}

@FunctionalInterface
interface MyInterfaces {
  public static final String NAME = "MyInterface";
  String sayHello(String name);
  default String withImpl(){
    return "Salutare" + sayHello ("Ioan");
  }
}
