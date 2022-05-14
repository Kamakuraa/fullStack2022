package ro.fasttrackit.homeworkCurs2.ex2.composition;

import ro.fasttrackit.homeworkCurs2.ex2.Person;

import java.util.List;

public interface PersonProvider {
  List<Person> readPerson();
}
