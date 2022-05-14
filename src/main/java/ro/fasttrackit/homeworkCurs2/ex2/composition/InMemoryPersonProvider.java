package ro.fasttrackit.homeworkCurs2.ex2.composition;


import ro.fasttrackit.homeworkCurs2.ex2.Person;

import java.util.List;

public class InMemoryPersonProvider implements PersonProvider{
  @Override
  public List<ro.fasttrackit.homeworkCurs2.ex2.Person> readPerson() {
    return List.of (new Person ("Alex", "Bratu", 30));
  }
}
