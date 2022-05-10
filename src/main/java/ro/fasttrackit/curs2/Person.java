package ro.fasttrackit.curs2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
  private String name;
  private int age;
  private String address;
  private boolean married;

  private Person() {

  }

  private Person(String name, int age, String affress, boolean married) {
    this.name = name;
    this.age = age;
    this.address = affress;
    this.married = married;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public boolean isMarried() {
    return married;
  }

//  public static PersonBuilder builder(){
//    return new PersonBuilder ();
//  }
//
//  static class PersonBuilder {
//    private final Person person = new Person ();
//
//    public void PersonBuilder name(String name) {
//      person.name = name;
//      return this;
//    }
//
//    public void PersonBuilder  age(int age) {
//      person.age = age;
//      return this;
//    }
//
//    public Person build() {
//      return person;
//    }
//  }
}
