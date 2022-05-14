package ro.fasttrackit.curs2.oop.interfaces;

import lombok.Data;

public interface Pet {
  String name();

  String saySomething();
}

@Data
class Dog implements Pet {

  private final String name;


  @Override
  public String name() {
    return null;
  }

  @Override
  public String saySomething() {
    return null;
  }
}


record Cat(String name) implements Pet {
  @Override
  public String saySomething() {
    return "miau";
  }
}
