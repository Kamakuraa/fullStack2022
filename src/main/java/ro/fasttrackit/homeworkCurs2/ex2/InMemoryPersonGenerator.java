package ro.fasttrackit.homeworkCurs2.ex2;

import java.util.List;

public class InMemoryPersonGenerator extends PersonReportGenerator{
  @Override
  public List<Person> readPersons() {
    return List.of (
      new Person ("Alex", "Bratu", 36),
      new Person ("Elena", "Chiritescu", 20),
      new Person ("Traian", "Popescu", 70)
    );
  }
}
