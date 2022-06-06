package ro.fasttrackit.homeworkCurs4.ex2;

import java.util.Objects;

public record Person(String name, int age, String address) {
  public String hasVisa() {
    return "Travel";
  }
}
