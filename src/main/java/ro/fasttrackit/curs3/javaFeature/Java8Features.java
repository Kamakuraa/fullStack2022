package ro.fasttrackit.curs3.javaFeature;

import java.util.List;
import java.util.Optional;

public class Java8Features {
  public static void main(String[] args) {
    lambdas ();
    stream ();
    optional ();
    methodReferences ();
  }

  private static void methodReferences() {
    names ().stream ()
      .map (String::length);

    names ().stream ()
      .map (String::valueOf)
      .toList ();
  }

  private static void optional() {
    System.out.println ("=======optional");
    Optional<String> myName = names ().stream ()
      .filter (a -> a.startsWith ("W"))
      .findFirst ()
      .map (name -> name.toUpperCase ())
      .map (Java8Features::abbreviate);
//MONAD
    System.out.println (myName);

    Optional<String> opt = Optional.of ("test");
    System.out.println (myName.orElse ("alta valoare "));
    System.out.println (opt);
    System.out.println (Optional.ofNullable (null));
    System.out.println (myName.orElseGet (() -> "test"));
  }

  private static void stream() {
    System.out.println ("---- stream");
    System.out.println (names ().stream ()
      .filter (name -> name.length () < 13)
      .count ());
    System.out.println ("=====paralel stream");
    names ().stream ()
      .filter (name -> name.length () < 13)
      .peek (elem -> System.out.println (Thread.currentThread ().getName ()))
      .map (Java8Features::abbreviate)
      .forEach (System.out::println);

    boolean condition = names ().stream ()
      .anyMatch (names -> names.startsWith ("C"));

    System.out.println (condition);
  }

  private static String abbreviate(String word) {
    return word.substring (0, word.indexOf (' ') + 2) + ".";
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
//    asa NU
//    use (new MyInterface () {
//      @Override
//      public Integer apply(Integer integer) {
//        return integer + 1;
//      }
//    });
    use (a -> a + 1);
  }

  private static void use(MyInterface logic) {
    System.out.println (logic.apply (3));
  }
}

@FunctionalInterface
interface MyInterface {
  Integer apply(Integer integer);

  default void describe() {
    System.out.println ("describing");
  }
}
