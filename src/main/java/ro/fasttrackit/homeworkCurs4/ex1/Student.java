package ro.fasttrackit.homeworkCurs4.ex1;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
  private final String name;
  private final LocalDate birthDate;
  private final int grade;

  public Student(String name, LocalDate birthDate, int grade) {
    this.name = name;
    this.birthDate = birthDate;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public int getGrade() {
    return grade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Student student = (Student) o;
    return grade == student.grade && Objects.equals (name, student.name) && Objects.equals (birthDate, student.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash (name, birthDate, grade);
  }

  @Override
  public String toString() {
    return "Student{" +
      "name='" + name + '\'' +
      ", birthDate=" + birthDate +
      ", grade=" + grade +
      '}';
  }
}
