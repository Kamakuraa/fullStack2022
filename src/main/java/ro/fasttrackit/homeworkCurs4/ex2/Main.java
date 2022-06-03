package ro.fasttrackit.homeworkCurs4.ex2;

public class Main {
  public static void main(String[] args) {
    LogicalSwitch logicalSwitch = new LogicalSwitch ();
    Person person = new Person ("Alex", 20, "Bucuresti");


    System.out.println (logicalSwitch.goTo (person));
    System.out.println (person.getName ().startsWith ("A"));
//    System.out.println (logicalSwitch.getLogicalSwitch ());
  }
}
