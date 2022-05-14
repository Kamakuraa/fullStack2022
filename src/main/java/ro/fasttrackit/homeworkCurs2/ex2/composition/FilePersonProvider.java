package ro.fasttrackit.homeworkCurs2.ex2.composition;



import ro.fasttrackit.homeworkCurs2.ex2.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FilePersonProvider implements PersonProvider {

  private final String sourceFile;

  public FilePersonProvider(String sourceFile) {
    this.sourceFile = sourceFile;
  }

  private Person readPerson(String line) {
    String[] tokens = line.split (",");
    return new Person (tokens[0],
      tokens[1],
      Integer.parseInt (tokens[2]));
  }

  @Override
  public List<ro.fasttrackit.homeworkCurs2.ex2.Person> readPerson() {
    try {
      return Files.lines (Path.of (sourceFile))
        .map (this::readPerson)
        .collect (Collectors.toList ());
    } catch (IOException e) {
      e.printStackTrace ();
    }
    return List.of ();
  }
}
