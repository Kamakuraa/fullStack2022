package ro.fasttrackit.curs3.javaFeature.curs4;

public class Java1516features {
  public static void main(String[] args) {
    records ();
    sealedClasses ();
  }

  private static void sealedClasses() {

  }

  private static void records() {
    Person1 person1 = new Person1 ("Alex");
    System.out.println (person1.name ());
    System.out.println (person1.toString ());
    System.out.println ("----------------");
    System.out.println (person1.name ().equals (person1));
  }
}

interface Being {
  String name();
}

record Person1(String name) implements Being {
}

sealed abstract class Person permits Students {
  abstract String name();
}

final class Students extends Person {
  @Override
  String name() {
    return "student";
  }
}
