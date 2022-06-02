package ro.fasttrackit.homeworkCurs3.ex2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Gym {
  private final List<Subscriptions> subscriptions;

  public Gym(List<Subscriptions> subscriptions) {
    this.subscriptions = new ArrayList<> (subscriptions);
  }

  public List<Subscriptions> getSubscriptions() {
    return new ArrayList<> (subscriptions);
  }


  public void registerTime(String memberTime, Duration duration) {
    Subscriptions subscriptions = findSubscriptionByName (memberTime);
    Duration currentTime = subscriptions.getExpireDate ().minus (duration);
    subscriptions.setExpireDate (currentTime);
  }

  public void addTime(String memberTime, Duration duration) {
    Subscriptions subscriptions = findSubscriptionByName (memberTime);
    Duration currentTime = subscriptions.getExpireDate ().plus (duration);
    subscriptions.setExpireDate (currentTime);
  }

  public Subscriptions findSubscriptionByName(String memberName) {
    return subscriptions.stream ()
      .filter (subscription -> subscription.getGymMember ().getName ().equals (memberName))
      .findFirst ()
      .orElse (new Subscriptions ());
  }

  public int getMaximumAge() {
    return getMembersAge ().stream ()
      .max (Integer::compare)
      .get ();
  }

  public int getMinAge() {
    return getMembersAge ().stream ()
      .min (Integer::compare)
      .get ();
  }

  public double getAverageAge() {
    return getMembersAge ().stream ()
      .mapToDouble (age -> age)
      .average ()
      .orElse (Double.NaN);
  }

  public long getTotalRemainingTime() {
    return subscriptions.stream ()
      .mapToLong (subscription -> subscription.getExpireDate ().toHours ())
      .sum ();
  }

  private void reduceSubscriptionTime(Subscriptions gymMember, Duration timeSpent) {
    Duration currentTime = gymMember.getExpireDate ().minus (timeSpent);
    gymMember.setExpireDate (currentTime);
  }

  private List<Integer> getMembersAge() {
    LocalDate todayDate = LocalDate.now ();

    return this.subscriptions.stream ()
      .map (subscriptions1 -> Period.between (subscriptions1.getGymMember ().getBirthdate (), todayDate).getYears ())
      .collect (Collectors.toList ());
  }

  @Override
  public String toString() {
    return "Gym{" +
      "subscriptions=" + subscriptions +
      '}';
  }
}
