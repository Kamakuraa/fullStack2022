package ro.fasttrackit.curs2.countries.composition;

import ro.fasttrackit.curs2.countries.Country;

import java.util.List;

public class InMemoryCountryProvider implements CountryProvider{
  @Override
  public List<Country> readCountries() {
    return List.of(
      new Country("Romania", "Bucharest"),
      new Country("Ungaria", "Budapest"),
      new Country("Moldova", "Chisinau"),
      new Country("UK", "London")
    );
  }
}
