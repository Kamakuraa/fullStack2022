package ro.fasttrackit.curs1;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
  private final LocalDate employmentDate;
  private final String name;
  private final Position position;

  public Employee(LocalDate employmentDate, String name, Position position) {
    this.employmentDate = employmentDate;
    this.name = name;
    this.position = position;
  }


  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  public String getName() {
    return name;
  }

  public Position getPosition() {
    return position;
  }

  public static Employee buildCEO(String name) {
    if (name == null || name.length () < 10) {
      return new Employee (LocalDate.now (), "Ion", Position.CEO);
    } else {
      return new CTO (LocalDate.now (), name);
    }
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Employee employee = (Employee) o;
    return Objects.equals (employmentDate, employee.employmentDate) && Objects.equals (name, employee.name) && position == employee.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash (employmentDate, name, position);
  }

  @Override
  public String toString() {
    return "Employee{" +
      "employmentDate=" + employmentDate +
      ", name='" + name + '\'' +
      ", position=" + position +
      '}';
  }
}

class CTO extends Employee {

  public CTO(LocalDate employmentDate, String name) {
    super (employmentDate, name, Position.CTO);
  }
}

enum Position {
  CEO,
  CFO,
  CTO,
  PROGRAMMER
}

