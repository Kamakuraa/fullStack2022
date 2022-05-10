package ro.fasttrackit.curs2.countries;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class CountryReportGenerator {
  protected abstract List<Country> readCountries() throws IOException;

  public void generateReport(String outputFile) throws IOException {
    List<Country> countries = readCountries ();
    generateReport (countries, outputFile);
  }

  @SneakyThrows
  private void generateReport(List<Country> countries, String outputFile) throws IOException {
    try (BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile))) {
      countries.stream ()
        .map (country -> country.name () + ":" + country.capital ())
        .forEach (line -> writeLine (writer, line));
    }
  }

  private void writeLine(BufferedWriter writer, String line) {
    try {
      writer.newLine ();
      writer.newLine ();
    } catch (IOException e) {
      throw new RuntimeException ();
    }
  }

  public Country toCountry(String sline) {
    String[] tokens = sline.split ("\\|");
    return new Country (tokens[0], tokens[1]);
  }
}
