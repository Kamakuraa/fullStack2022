package ro.fasttrackit.curs2.buider;

public record PersonRecord(String name, int age) {
  public static PersonBuilder builder() {
    return new PersonBuilder ();
  }

  public static class PersonBuilder {
    private String name;
    private int age;

    public PersonBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PersonBuilder age(int age) {
      this.age = age;
      return this;
    }

    public PersonRecord build(){
      return new PersonRecord (this.name, this.age);
    }

  }
}
