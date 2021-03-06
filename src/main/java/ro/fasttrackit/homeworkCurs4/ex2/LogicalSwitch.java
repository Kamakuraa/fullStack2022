package ro.fasttrackit.homeworkCurs4.ex2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LogicalSwitch {
  private final Map<Predicate<Person>, Function<Person, String>> logicalSwitch = new LinkedHashMap<> ();

  public LogicalSwitch() {
    logicalSwitch.put (person -> person.age () > 18, person -> person.hasVisa () + " in USA");
    logicalSwitch.put (person -> person.name ().startsWith ("A"), person -> person.hasVisa () + " in Australia");
  }
  public String goTo(Person person) {
    return logicalSwitch.entrySet ().stream ()
      .filter (p -> p.getKey ().test (person) )
      .map (p -> p.getValue ().apply (person))
      .collect (Collectors.joining (", "));
  }

}
