package ro.fasttrackit.homeworkCurs4.ex3;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    AnimalService animalService = new AnimalService (List.of (
      new Parrot ("Parrot"),
      new Chicken ("Domerstic bird", "white"),
      new Cat ("Pusy")
    ));
    System.out.println (animalService.getAnimalList ());
    System.out.println (animalService.getAnimalList ().get (1));
  }
}
