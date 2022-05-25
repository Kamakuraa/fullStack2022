package ro.fasttrackit.curs2.curs31;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Features {
  public static void main(String[] args) {
    lambdas ();
    streams ();
    optional ();
    methodReferences ();

  }

  private static void methodReferences() {
    PersonManager personManager = new PersonManager ();
    names ().stream ()
      .map (String::length)
      .toList ();

    names ().stream ()
      .map (String::valueOf)
      .toList ();
  }

  private static void optional() {
    System.out.println ("=====optional");
    Optional<String> myName = names ().stream ()
      .filter (name -> name.startsWith ("W"))
      .findFirst ()
      .map (String::toUpperCase)
      .map (Java8Features::abbreviate);

    // monad este optional
  }

  private static void streams() {
    System.out.println (names ().stream ()
      .filter (name -> name.length () < 13)
      .count ());

    names ().stream ()
      .filter (name -> name.length () < 13)
      .peek (elem -> System.out.println (Thread.currentThread ().getName ()))
      .map (Java8Features::abbreviate)
      .forEach (System.out::println);

    boolean condition = names ().stream ()
      .anyMatch (name -> name.startsWith ("A"));

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
    use (a -> a + 1);
    use (new MyInterface () {
           @Override
           public Integer apply(Integer input) {
             return input + 1;
           }
         }
    );
    System.out.println (List.of ()
      .stream ()
      .collect (Collectors.toList ()));
  }


  private static void use(MyInterface logic) {
    System.out.println (logic.apply (3));
  }
}

class Person {
  String name;

  void doSomething(Function<Integer, String> dos) {

  }
}

@FunctionalInterface
interface MyInterface {
  Integer apply(Integer input);

  default void describe() {
    System.out.println ("describing ");
  }
}
