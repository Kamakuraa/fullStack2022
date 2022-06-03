package ro.fasttrackit.homeworkCurs4.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentService {
  private final List<Student> student = new ArrayList<> ();

  public StudentService(List<Student> student) {
    this.student.addAll (student);
  }

  public List<Student> getStudent() {
    return new ArrayList<> (student);
  }

  public String getNameAndAverageGrade() {
    return student.stream ()
      .collect (Collectors.teeing (
        Collectors.mapping (Student::getName, Collectors.toList ()),
        Collectors.averagingInt (Student::getGrade),
        (names, average) -> names + " have an average grade of " + average
      ));
  }

  public List<String> getStudentName() {
    return student.stream ()
      .map (s -> s.getName ())
      .collect (Collectors.toList ());
  }

  public List<String> allocateCourses() {
    return student.stream ()
      .map (s -> s.getName () + " participa la curs  " + getRandomCourse ())
      .collect (Collectors.toList ());
  }

  public String getRandomCourse() {
    Random random = new Random ();

    String firstCourse = """
      "course" : "Math 101",
      "semester" : 2
      """.formatted ("Math 101", 2);


    String secondCourse = """
      "course" : "English",
      "semester" : 2
      """.formatted ("English", 1);

    String thirdCourse = """
      "course" : "Java",
      "semester" : 2
      """.formatted ("JAVA", 2);
    List<String> courses = List.of (firstCourse, secondCourse, thirdCourse);
    return courses.get (random.nextInt (courses.size ()));

  }
}
