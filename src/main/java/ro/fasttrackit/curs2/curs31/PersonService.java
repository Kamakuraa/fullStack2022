package ro.fasttrackit.curs2.curs31;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Student(String name, int age) {
}

public class PersonService {
  private static final List<Student> students = new ArrayList<> (List.of (
    new Student ("Alex", 36),
    new Student ("Geo", 22),
    new Student ("Cris", 33),
    new Student ("Titi", 43)
  ));

  public static void main(String[] args) {

    Map<Integer, List<Student>> collect = students.stream ().collect (Collectors.groupingBy (
      Student::age));

    System.out.println (collect);

    Map<Integer, List<String>> groupNames = students.stream ()
      .collect (Collectors.groupingBy (Student::age, Collectors.mapping (Student::name, Collectors.toList ())));
    System.out.println (groupNames);
  }

  private Integer myGroupingLogic(Student student) {
    return student.age ();
  }
}
