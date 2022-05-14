package ro.fasttrackit.curs2.countries;


import lombok.RequiredArgsConstructor;
import ro.fasttrackit.curs2.countries.composition.CountryProvider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
public abstract class CountryProviderReportGenerator {

private final CountryProvider countryProvider;

  public void generateReport(String outputFile) throws IOException{
    List<Country> countries = countryProvider.readCountries ();
    generateReport (countries, outputFile);
  }

  private void generateReport(List<Country> countries, String outputFile) throws IOException {
    try (BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile))) {
      countries.stream ()
        .map (country -> country.name () + " : " + country.capital ())
        .forEach (line -> writeLine (writer, line));
    }
  }

  private void writeLine(BufferedWriter writer, String line) {
    try {
      writer.write (line);
      writer.newLine ();
    } catch (IOException e) {
      throw new RuntimeException ();
    }
  }
}
