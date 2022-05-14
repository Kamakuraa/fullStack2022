package ro.fasttrackit.curs2.buider;

public class Person {
  private String name;
  private int age;
  private String address;
  private boolean married;

  private Person(String name, int age, String address, boolean married) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.married = married;
  }

  public Person() {
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

  public static PersonBuilder builder(){
    return new PersonBuilder ();
  }

  public static class PersonBuilder {
    private final Person person = new Person ();

    public PersonBuilder name(String name) {
      person.name = name;
      return this;
    }

    public PersonBuilder age(int age) {
      person.age = age;
      return this;
    }

    public PersonBuilder address(String address) {
      person.address = address;
      return this;
    }

    public PersonBuilder married(boolean married) {
      person.married = married;
      return this;
    }



    public Person build() {
      return person;
    }
  }
}
