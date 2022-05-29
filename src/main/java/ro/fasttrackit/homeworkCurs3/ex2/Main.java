package ro.fasttrackit.homeworkCurs3.ex2;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    GymMember gymMember = new GymMember ("Alex", LocalDate.of (1985, 5, 10));
    GymMember gymMember1 = new GymMember ("Cristi", LocalDate.of (1983, 3, 22));

    Subscriptions subscriptions = new Subscriptions (gymMember);
    Subscriptions subscriptions1 = new Subscriptions (gymMember1);
    Gym gym = new Gym(List.of(subscriptions, subscriptions1));

    System.out.println(gym);
    gym.registerTime ("Alex", Duration.ofHours(10));
    System.out.println(gym);

    System.out.println(gym.getAverageAge());
    System.out.println(gym.getMinAge ());
    System.out.println(gym.getMaximumAge());

    System.out.println(gym.getTotalRemainingTime ());

    gym.addTime ("Alex", Duration.ofHours(10));
    System.out.println(gym);

    System.out.println(gym.findSubscriptionByName("Alex"));

    SubscriptionReportGenerator subscriptionReportGenerator = new SubscriptionReportGenerator();

    gym.registerTime ("Alex", Duration.ofHours(20));
    System.out.println(gym.findSubscriptionByName("Alex"));
    System.out.println(gym);
    subscriptionReportGenerator.generateReport("time-report-" + LocalDate.now().toString() + ".txt", gym.getSubscriptions());
  }
}
