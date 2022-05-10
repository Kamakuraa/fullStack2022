package ro.fasttrackit.curs2.oop.interfaces;

import lombok.Data;

public interface Pet {
  String name();
  String sayCeva();
}

@Data
class Dog implements Pet{

  private String name;

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public String sayCeva() {
    return "woof";
  }
}

record Cat(String name) implements Pet{

  @Override
  public String sayCeva() {
    return "miau";
  }
}
