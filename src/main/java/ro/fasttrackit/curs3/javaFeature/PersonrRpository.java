package ro.fasttrackit.curs3.javaFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonrRpository {
  private static List<String> persons = new ArrayList<> (List.of ("Dan", "Cornel"));

//  public String findCity(String city){
//    String myCity = ofN
//  }
  public Optional<String> findByName(String name) {
    for (String person : persons) {
      if (person.equalsIgnoreCase (name)) {
        return Optional.of (person);
      }
    }
    return Optional.empty ();
  }

  public static void main(String[] args) {
    PersonrRpository repo = new PersonrRpository ();
    repo.findByName ("Dan");

  }
}
