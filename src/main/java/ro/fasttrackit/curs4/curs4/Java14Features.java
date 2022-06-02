package ro.fasttrackit.curs4.curs4;

public class Java14Features {
  public static void main(String[] args) {
    switchExpression ("abc");
  }

  private static void switchExpression(String value) {
    switch (value) {
      case "abc":
        System.out.println ("Is abc");
        break;
      case "def":
        System.out.println ("is def");
        break;
      default:
        System.out.println ("other");
    }
    String result = switch (value) {
      case "abc", "def" -> {
        System.out.println ("Mai multe de facut");
        yield "Is abc";
      }
      case "xyz" -> "result";
      default -> "def val";
    };
    System.out.println (result);
  }
}

interface Being {
  public static final int a = 3;

  default void live() {
    System.out.println (getMessge ());
  }

  default String getMessge() {
    return "I'm living";
  }
}

record Student(String name, int age) implements Being {
  Student(String name) {
    this (name, 22);
  }

}
