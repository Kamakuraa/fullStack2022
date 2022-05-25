package ro.fasttrackit.curs5.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs5.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
  private final List<Person> persons = List.of (
    new Person (1, "Ana", 29),
    new Person (2, "Ioana", 32),
    new Person (3, "Georg", 59),
    new Person (4, "Paul", 19),
    new Person (5, "Victor", 22)
  );

  public List<Person> getAll(String name) {
    if (name == null) {
      return persons;
    } else {
      return persons.stream ()
        .filter (person -> person.getName ().contains (name))
        .collect (Collectors.toList ());
    }
  }

  public Optional<Person> getPersorn(int personId) {
    return persons.stream ()
      .filter (person -> person.getId () == personId)
      .findFirst ();
  }
}
