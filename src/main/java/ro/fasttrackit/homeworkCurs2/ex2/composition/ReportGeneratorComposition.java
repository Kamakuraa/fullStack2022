package ro.fasttrackit.homeworkCurs2.ex2.composition;

import ro.fasttrackit.curs2.countries.Country;
import ro.fasttrackit.homeworkCurs2.ex2.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGeneratorComposition {
  private final PersonProvider personProvider;

  public ReportGeneratorComposition(PersonProvider personProvider) {
    this.personProvider = personProvider;
  }

  public void generateReport(String file, int min, int max) throws IOException {
    List<Person> persons = personProvider.readPerson ();
    writerReport (persons, file, min, max);
  }

  private void writerReport(List<Person> persons, String outputFile, int min, int max) throws IOException {
    try (BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile))) {
      persons.stream ()
        .filter (person -> person.getAge () >= min)
        .filter (person -> person.getAge () <= max)
        .map (person -> person.getFirstName () + " " + person.getAge ())
        .forEach (line -> writerLine (writer, line));
    }
  }

  private void writerLine(BufferedWriter writer, String line) {
    try {
      writer.write (line);
      writer.newLine ();
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }
}
