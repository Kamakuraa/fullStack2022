package ro.fasttrackit.curs4.curs4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class PersonService {
  private final List<Person> person;

  public PersonService(List<Person> person) {
    this.person = Optional.ofNullable (person)
      .map (p -> new ArrayList (p))
      .orElseGet (ArrayList::new);

//    if (person!= null){
//      this.person.addAll (person);
//    }


//    if (person == null) {
//      this.person = new ArrayList<> ();
//    } else {
//      this.person = new ArrayList<> (person);
//    }
  }


  public Map<Range, List<Person>> groupByRangeAge(int... ages) {
    Ranges ranges = new Ranges (ages);

    return this.person.stream ()
      .collect(Collectors.groupingBy (person1 -> ranges.getRange (person1.age ())));
  }
}
