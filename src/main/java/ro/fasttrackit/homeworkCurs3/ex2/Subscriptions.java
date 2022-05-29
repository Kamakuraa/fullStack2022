package ro.fasttrackit.homeworkCurs3.ex2;

import java.time.Duration;
import java.util.Objects;

public class Subscriptions {
  private GymMember gymMember;
  private Duration expireDate;
  private TimeCategory timeCategory;


  public Subscriptions(GymMember gymMember) {
    this.gymMember = gymMember;
    this.expireDate = Duration.ofHours(30);
    changeTimeCategory();
  }

  public Subscriptions() {

  }

  public GymMember getGymMember() {
    return gymMember;
  }

  public Duration getExpireDate() {
    return expireDate;
  }

  public TimeCategory getTimeCategory() {
    return timeCategory;
  }

  public void setExpireDate(Duration expireDate) {
    this.expireDate = expireDate;
    changeTimeCategory ();
  }

  private void changeTimeCategory() {
    if (this.expireDate.toHours () < 10) {
      this.timeCategory = TimeCategory.RED;
    } else if (this.expireDate.toHours () < 30) {
      this.timeCategory = TimeCategory.YELLOW;
    } else {
      this.timeCategory = TimeCategory.GREEN;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Subscriptions that = (Subscriptions) o;
    return Objects.equals (gymMember, that.gymMember) && Objects.equals (expireDate, that.expireDate) && timeCategory == that.timeCategory;
  }

  @Override
  public int hashCode() {
    return Objects.hash (gymMember, expireDate, timeCategory);
  }

  @Override
  public String toString() {
    return "Subscriptions{" +
      "gymMember=" + gymMember +
      ", expireDate=" + expireDate +
      ", timeCategory=" + timeCategory +
      '}';
  }
}
