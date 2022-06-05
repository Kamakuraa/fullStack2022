package ro.fasttrackit.homeworkCurs4.ex1;

import java.time.LocalDate;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println (new Student ("Alex", LocalDate.of (1985, 06, 10), 8));
    System.out.println (new Student ("Cristi", LocalDate.now (), 1));
    Student student = new Student ("Alex", LocalDate.of (1985, 06, 10), 7);
    Student student1 = new Student ("George", LocalDate.of (2000, 03, 3), 6);
    Student student2 = new Student ("Marius", LocalDate.of (1999, 11, 22), 6);
    StudentService studentService = new StudentService (List.of (student, student1, student2));
    System.out.println (studentService.getRandomCourse ());
    System.out.println (studentService.getStudentName ());

    System.out.println (studentService.getNameAndAverageGrade ());
    System.out.println (studentService.getStudentPlace (student) + "++++");
  }
}
