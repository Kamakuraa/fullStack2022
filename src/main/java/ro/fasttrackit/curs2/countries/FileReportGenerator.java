package ro.fasttrackit.curs2.countries;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
@RequiredArgsConstructor
public class FileReportGenerator extends CountryReportGenerator{
  private final String sourceFile;

  @Override
  protected List<Country> readCountries() throws IOException {
    return Files.lines (Path.of (sourceFile))
      .map (this::toCountry)
      .toList ();
  }
}
