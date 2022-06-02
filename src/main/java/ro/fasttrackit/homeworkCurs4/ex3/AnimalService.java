package ro.fasttrackit.homeworkCurs4.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AnimalService {
  private final List<Animal> animalList;

  public AnimalService(List<Animal> animal) {

    this.animalList = Optional.ofNullable (animal)
      .map (animals -> new ArrayList (animals))
      .orElseGet (ArrayList::new);
  }

  public List<Animal> getAnimalList() {
    return Collections.unmodifiableList (animalList);
  }

  public void makeSound(Animal animal) {
    System.out.println("The specific noise of this animal is " + animal.makeNoise());
  }
}
