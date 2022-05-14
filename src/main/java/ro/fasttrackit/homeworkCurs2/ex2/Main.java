package ro.fasttrackit.homeworkCurs2.ex2;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    FilePersonReportGenerator fprg = new FilePersonReportGenerator ("src/main/resources/people.txt");
    fprg.generateReport ("young.txt", 0, 30);
    fprg.generateReport ("stillyoung.txt", 30, 50);
    fprg.generateReport ("notsooyoung.txt", 31, 50);

    new InMemoryPersonGenerator ().generateReport ("inMemoryReportYoung", 0, 30);
    new InMemoryPersonGenerator ().generateReport ("InMemoryReportStillYoung", 30, 50);
    new InMemoryPersonGenerator ().generateReport ("inMemoryReportOld", 50, 99);
  }
}
