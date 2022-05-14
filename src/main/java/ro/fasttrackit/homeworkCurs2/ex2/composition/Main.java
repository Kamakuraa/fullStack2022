package ro.fasttrackit.homeworkCurs2.ex2.composition;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    ReportGeneratorComposition reportGeneratorComposition = new ReportGeneratorComposition (
      new FilePersonProvider ("src/main/resources/people.txt"));

    reportGeneratorComposition.generateReport ("output-composition.txt",  0, 30);
  }
}
