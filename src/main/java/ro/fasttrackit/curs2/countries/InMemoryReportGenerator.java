package ro.fasttrackit.curs2.countries;

import java.util.List;

public class InMemoryReportGenerator extends CountryReportGenerator{
  @Override
  protected List<Country> readCountries() {
    return List.of (
      new Country ("Romania", "Bucharest"),
      new Country ("Ungaria", "Budapest"),
      new Country ("Moldova", "Chisinau"),
      new Country ("UK", "Londra")


    );
  }
}
