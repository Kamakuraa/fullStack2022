package ro.fasttrackit.interviu;

import ro.fasttrackit.homeworkCurs2.ex2.Person;
import ro.fasttrackit.homeworkCurs2.ex2.composition.PersonProvider;

import java.util.List;

public class Main extends Person {
  public Main(String firstName, String lastName, int age) {
    super (firstName, lastName, age);
  }
}

class Parinte implements PersonProvider {

  @Override
  public List<Person> readPerson() {
    return null;
  }
}
