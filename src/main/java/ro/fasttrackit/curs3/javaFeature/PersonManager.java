package ro.fasttrackit.curs3.javaFeature;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
  private static List<String> persons = new ArrayList<> (List.of ("Dan", "Cornel"));

  public static void main(String[] args) {
    String alex = persons.stream ()
      .filter (name -> name.equalsIgnoreCase ("Alex"))
      .findFirst ()
      .orElse (addPerson ("Alex"));
    System.out.println (alex);
    System.out.println (persons);
  }

  private static String addPerson(String alex) {
    persons.add (alex);
    return alex;
  }
}
