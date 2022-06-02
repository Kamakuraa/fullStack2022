package ro.fasttrackit.curs2.curs31;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
  private final List<String> persons = new ArrayList<> ();

  public String findByName(String name) {
    return persons.stream ()
      .filter (person -> person.equalsIgnoreCase (name))
      .findFirst ()
      .orElse (null);
  }

  public static void main(String[] args) {
    PersonRepository personRepository = new PersonRepository ();
    String person = personRepository.findByName ("Dan");
  }

}
