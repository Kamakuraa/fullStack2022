package ro.fasttrackit.curs1;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
  public static void main(String[] args) {
    Student student = new Student ("Alex", new ArrayList<> (List.of (5, 2, 10)));
    student.getGrades ().set (1, 10);

    System.out.println (student);
  }
}
