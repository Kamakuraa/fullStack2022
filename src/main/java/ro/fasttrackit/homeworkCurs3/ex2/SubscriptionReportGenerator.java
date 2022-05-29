package ro.fasttrackit.homeworkCurs3.ex2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SubscriptionReportGenerator {
  public void generateReport(String outputFile, List<Subscriptions> subscriptionsList) throws IOException {
    List<Subscriptions> subscriptions = subscriptionsList;
    writeReport (subscriptions, outputFile);
  }

  private void writeReport(List<Subscriptions> subscriptions, String outputFile) throws IOException {
    try (BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile))) {
      Map<TimeCategory, List<Subscriptions>> subscriptionsGroupByAge = subscriptions.stream ()
        .collect (Collectors.groupingBy (Subscriptions::getTimeCategory));

      for (TimeCategory timeCategory : TimeCategory.values ()) {
        writeInLine (writer, timeCategory + ": ");

        if (subscriptionsGroupByAge.get (timeCategory) != null) {
          subscriptionsGroupByAge.get (timeCategory).stream ()
            .map (person -> person.getGymMember ().getName ())
            .forEach (line -> writeInLine (writer, line));
        }
      }
    }
  }

  private void writeInLine(BufferedWriter writer, String line) {
    try {
      writer.write (line);
    } catch (IOException exception) {
      throw new RuntimeException (exception);
    }
  }
}
