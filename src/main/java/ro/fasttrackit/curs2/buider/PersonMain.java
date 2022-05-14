package ro.fasttrackit.curs2.buider;

public class PersonMain {
  public static void main(String[] args) {
    Person person = new Person.PersonBuilder ()
      .name ("Ana")
      .address ("Bucuresti")
      .age (12)
      .married (false)
      .build ();
    System.out.println (person);

    Person.PersonBuilder builder = new Person.PersonBuilder ();
    builder.name ("Ana");
    builder.age (22);
    Person ana = builder.build ();


    System.out.println (person);


    Person.PersonBuilder pb;
    PersonRecord.PersonBuilder prb;
    System.out.println (PersonRecord.builder ()
      .age (12)
      .name ("Ana")
      .build ());

    NewPerson newPerson = NewPerson.builder ()
      .address ("Bucuresti")
      .age (36)
      .name ("Alex")
      .married (false)
      .build ();

    System.out.println (newPerson + " eu ");
    var maria = PersonLombok.builder ()
      .name ("Maria")
      .age (22)
      .build ();

    System.out.println (maria.withAge (23));

  }
}
