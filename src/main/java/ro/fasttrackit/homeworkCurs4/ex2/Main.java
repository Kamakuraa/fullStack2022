package ro.fasttrackit.homeworkCurs4.ex2;

import java.time.Instant;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    LogicalSwitch logicalSwitch = new LogicalSwitch ();
    Person person = new Person ("Alex", 20, "Bucuresti");


    System.out.println (logicalSwitch.goTo (person));
    System.out.println (person.getName ().startsWith ("A"));
  }
}
