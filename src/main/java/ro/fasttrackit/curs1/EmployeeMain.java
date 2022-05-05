package ro.fasttrackit.curs1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeeMain {
  public static void main(String[] args) {
    Employee ceo = new Employee (LocalDate.now ().minus (10, ChronoUnit.DAYS), "Ana", Position.CEO);
    Employee ceo1 = Employee.buildCEO ("BigBossMareSefToday");
    System.out.println (ceo.getClass ());
    System.out.println (ceo1);
  }
}
