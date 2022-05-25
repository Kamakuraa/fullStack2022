package ro.fasttrackit.curs2.curs31;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
  private static List<String> persons = new ArrayList<> (List.of ("Dan", "Cornel"));

  public static void main(String[] args) {
    String dan = "Dan";
    String alex = persons.stream ()
      .filter (name -> name.equalsIgnoreCase (dan)).findFirst ()
      .orElseGet (() -> addPerson (dan));
    System.out.println (dan);
    System.out.println (persons);
  }

  private static String addPerson(String person) {
    persons.add (person);
    return person;
  }


}
