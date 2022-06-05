package ro.fasttrackit.homeworkCurs4.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentService {
  private final List<Student> students = new ArrayList<> ();

  public StudentService(List<Student> student) {
    this.students.addAll (student);
  }

  public List<Student> getStudents() {
    return new ArrayList<> (students);
  }

  public String getStudentPlace(Student student) {
    return switch (students.indexOf (student)) {
      case 0, 1, 2 -> "1st grade";
      case 3 -> "5th grade";
      default -> "7th grade";
    };
  }

  public String getNameAndAverageGrade() {
    return students.stream ()
      .collect (Collectors.teeing (
        Collectors.mapping (Student::getName, Collectors.toList ()),
        Collectors.averagingInt (Student::getGrade),
        (names, average) -> names + " have an average grade of " + average
      ));
  }

  public List<String> getStudentName() {
    return students.stream ()
      .map (s -> s.getName ())
      .collect (Collectors.toList ());
  }

  public List<String> allocateCourses() {
    return students.stream ()
      .map (s -> s.getName () + " participa la curs  " + getRandomCourse ())
      .collect (Collectors.toList ());
  }

  public String getRandomCourse() {
    Random random = new Random ();

    String firstCourse = """
      'course':%s,
      'semester':%d
      """.formatted ("Math 101", 2);


    String secondCourse = """
      'course':%s,
      'semester':%d
      """.formatted ("English", 1);

    String thirdCourse = """
      'course':%s,
      'semester':%d
      """.formatted ("JAVA", 2);
    List<String> courses = List.of (firstCourse, secondCourse, thirdCourse);
    return courses.get (random.nextInt (courses.size ()));

  }
}
