package ro.fasttrackit.homeworkCurs3.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FilePeopleReportGenerator extends PeopleReportGenerator {
  private final String sourceFile;

  public FilePeopleReportGenerator(String sourceFile) {
    this.sourceFile = sourceFile;
  }

  @Override
  protected List<People> readPeoples() {
    try {
      return Files.lines (Path.of (sourceFile))
        .map (this::readPeople)
        .collect (Collectors.toList ());
    } catch (IOException e) {
      System.err.println ("Could not read from file " + sourceFile);
    }
    return List.of ();
  }

  private People readPeople(String line) {
    String[] countryInfo = line.split (",");
    return new People (
      countryInfo[0],
      countryInfo[1],
      Integer.parseInt (countryInfo[2])
    );
  }
}
