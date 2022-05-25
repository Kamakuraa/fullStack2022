package ro.fasttrackit.curs3.javaFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record Student(String name, int age){}
public class PersonService {
  private static final List<Student> students = new ArrayList<> (
    List.of (
      new Student ("Alex", 10),
      new Student ("Alex", 1011),
      new Student ("Alex", 101),
      new Student ("Alex", 1)
    )
  );

  public static void main(String[] args) {
    System.out.println (students.stream ()
      .collect (Collectors.groupingBy (Student::age)));

    System.out.println (students.stream ()
      .collect (Collectors.groupingBy (Student::age, Collectors.mapping (Student::name, Collectors.toList ()))));
  }
}
