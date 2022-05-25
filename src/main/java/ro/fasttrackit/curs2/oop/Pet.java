package ro.fasttrackit.curs2.oop;

import lombok.ToString;

@ToString
abstract class Pet {
  private final String name;

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract String makeSound();
}

interface Top {
}

interface Left extends Top {
}

interface Right extends Top {
}

interface Down extends Left, Right {
}

interface BusinessOperation<T> {
  default T execute() {
    validate ();
    return doExecute ();
  }

  T doExecute();

  void validate();
}
