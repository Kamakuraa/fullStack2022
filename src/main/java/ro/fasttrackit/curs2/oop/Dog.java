package ro.fasttrackit.curs2.oop;

import lombok.ToString;

@ToString(callSuper = true)
public class Dog extends Pet {
  public Dog(String name) {
    super (name);
  }

  @Override
  public String makeSound() {
    return "woof";
  }


}
