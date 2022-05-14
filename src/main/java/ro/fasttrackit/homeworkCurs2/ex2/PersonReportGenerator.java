package ro.fasttrackit.homeworkCurs2.ex2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class PersonReportGenerator {
  protected abstract List<Person> readPersons();

  public void generateReport(String outputFile, int min, int max) throws IOException{
    List<Person> persons = readPersons ();
    generateReport (persons, outputFile, min, max);
  }

  private void generateReport(List<Person> persons, String outputFile, int min, int max) throws IOException {
    try (BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile))) {
      persons.stream ()
        .filter (person -> person.getAge () >= min)
        .filter (person -> person.getAge () <= max)
        .forEach (line -> writerLine (writer, line));
    }
  }

  private void writerLine(BufferedWriter writer, Person line) {
    try {
      writer.write (String.valueOf (line));
      writer.newLine ();
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }
}
