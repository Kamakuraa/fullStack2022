package ro.fasttrackit.curs2;

public class Main {
  public static void main(String[] args) {
    System.out.println ("curs 2");
    Person.PersonBuilder builder = new Person.PersonBuilder ();

    builder.name ("Alex");
    builder.age (12);


    Person person = Person.builder ()
      .name ("Alex")
      .age (12)
      .address ("Bucuresti")
      .build ();
    PersonLombok maria = new PersonLombok.PersonLombokBuilder ().age (12).name ("Maria").build ();
    System.out.println (maria);
    System.out.println (maria.withAge (33));
    System.out.println (maria);
  }




}
