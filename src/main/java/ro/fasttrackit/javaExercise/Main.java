package ro.fasttrackit.javaExercise;

public class Main {
  public static void main(String[] args) {
    Pizza pizza = new Pizza (1, "ceva");
    var pizzaNew = pizza.builder ()
      .name ("Vegy")
      .price (30)
      .build ();

    System.out.println (pizzaNew);
  }
}
