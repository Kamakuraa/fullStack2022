package ro.fasttrackit.javaExercise;

public class Main {
  public static void main(String[] args) {
    Pizza pizza = new Pizza (1, "ceva");
    var pizzaNew = pizza.builder ()
      .name ("Vegy")
      .price (30)
      .build ();

    System.out.println (pizzaNew);
    String string = new String ("aaa");
    String string1 = "aaa";
    System.out.println (string.equals (string1));
    System.out.println (string.substring (1, 3));
  }
}
