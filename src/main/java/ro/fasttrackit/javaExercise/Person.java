package ro.fasttrackit.javaExercise;

import java.util.Objects;

public final class Person {
  private final String name;

  private Person(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Person person = (Person) o;
    return Objects.equals (name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash (name);
  }

  public static void main(String[] args) {
    var p = new Person ("Alex");
    System.out.println (p.name);
    System.out.println (p.name.startsWith ("A"));
  }


}
