package ro.fasttrackit.homeworkCurs3.ex1;

import java.util.List;

public class InMemoryPeopleReportGenerator extends PeopleReportGenerator{
  @Override
  protected List<People> readPeoples() {
    return List.of (
      new People ("Alex", "Bratu", 36),
      new People ("Corin", "Andrei", 22)
    );
  }
}
