package ro.fasttrackit.curs1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
  private final String name;
  private final List<Integer> grades;

  public Student(String name, List<Integer> grades) {
    this.name = name;
    this.grades = new ArrayList<> (grades);
  }

  public String getName() {
    return name;
  }

  public List<Integer> getGrades() {
    return new ArrayList<> (grades);
  }

  @Override
  public String toString() {
    return "Student{" +
      "name='" + name + '\'' +
      ", grades=" + grades +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Student student = (Student) o;
    return Objects.equals (name, student.name) && Objects.equals (grades, student.grades);
  }

  @Override
  public int hashCode() {
    return Objects.hash (name, grades);
  }
}
