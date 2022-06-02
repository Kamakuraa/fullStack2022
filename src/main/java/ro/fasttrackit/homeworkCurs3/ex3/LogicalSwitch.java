package ro.fasttrackit.homeworkCurs3.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class LogicalSwitch {
  private final Map<Predicate<Person>, Function<Person, String>> logicalSwitch = new HashMap<> ();

  public LogicalSwitch() {
    logicalSwitch.put (person -> person.name ().length ()>10, person -> person.name ());
    logicalSwitch.put(person -> nameStartsWith(person, "A"), this::messageForStartsWith);
    logicalSwitch.put(person -> person.age () > 18, this::goVote);
  }

  public static void main(String[] args) {
    LogicalSwitch logicalSwitch = new LogicalSwitch ();
    Person person = new Person ("Alex", 36);
    System.out.println (logicalSwitch.dipatch (person));
  }
  public String dipatch(Person person) {
    return logicalSwitch.entrySet().stream()
      .filter(entry -> entry.getKey().test(person))
      .map(entry -> entry.getValue().apply(person))
      .collect(joining(lineSeparator()));
  }

  private String goVote(Person person) {
    return "Voted for me";
  }

  private String messageForStartsWith(Person person) {
    return person.name () + " starts with A";
  }

  private boolean nameStartsWith(Person person, String letter) {
    return person.name ().startsWith(letter);
  }
}
