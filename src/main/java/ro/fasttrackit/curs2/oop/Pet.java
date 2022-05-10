package ro.fasttrackit.curs2.oop;

import lombok.ToString;

@ToString
public abstract class Pet {
  private final String name;

  protected Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract String makeSound();
}

interface Top {

  int field = 1;

  int getAge();
  default void process() {
    System.out.println (field);
    subProb ();
  }

  private void subProb() {
    System.out.println ("private method in interface");
  }
}


interface Left extends Top {
}

interface Right extends Top {
}

interface Down extends Left, Right {
}

interface BusinessOperation<T>{
  default T execute(){
    validate();
    return doExecute();
  }

  T doExecute();

  void validate();
}
