package ro.fasttrackit.curs4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

public class PersonService {
  private final List<Person> person;

  public PersonService(List<Person> person) {
    this.person = ofNullable (person)
      .map (people -> new ArrayList (people))
      .orElseGet (ArrayList::new);
  }

  public Map<Range, List<Person>> groupByAgeRange(int... ages) {
    return null;
  }
}
