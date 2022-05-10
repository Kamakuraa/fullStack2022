package ro.fasttrackit.curs2.countries;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    var gen = new InMemoryReportGenerator ();
    gen.generateReport ("output.txt");

    var gen1= new FileReportGenerator ("src/main/resources/countries.txt");
    gen1.generateReport ("output.txt");
  }
}
