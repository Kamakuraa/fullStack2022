package ro.fasttrackit.javaExercise;

import lombok.Builder;

import java.util.Objects;

@Builder
public  class Pizza {
  private final int price;
  private final String name;

  public Pizza(int price, String name) {
    this.price = price;
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Pizza pizza = (Pizza) o;
    return price == pizza.price && Objects.equals (name, pizza.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash (price, name);
  }

  @Override
  public String toString() {
    return "Pizza{" +
      "price=" + price +
      ", name='" + name + '\'' +
      '}';
  }
}
