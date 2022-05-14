package ro.fasttrackit.homeworkCurs2.ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilePersonReportGenerator extends PersonReportGenerator {
  private final String sourceFile;

  public FilePersonReportGenerator(String sourceFile) {
    this.sourceFile = sourceFile;
  }

  @Override
  public List<Person> readPersons() {
    try {
      return Files.lines (Path.of (sourceFile))
        .map (this::readPerson)
        .toList ();
    } catch (IOException e) {
      e.printStackTrace ();
    }
    return List.of ();
  }

  private Person readPerson(String line) {
    String[] tokens = line.split (",");
    return new Person (tokens[0],
      tokens[1],
      Integer.parseInt (tokens[2]));
  }

}
