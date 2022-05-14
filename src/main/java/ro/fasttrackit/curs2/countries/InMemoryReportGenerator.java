package ro.fasttrackit.curs2.countries;

import java.util.List;

public class InMemoryReportGenerator extends CountryReportGenerator {

  @Override
  List<Country> readCountries() {
    return List.of (
      new Country ("Romania", "Bucharest"),
      new Country ("USA", "Washington")
    );
  }
}
