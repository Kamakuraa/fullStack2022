package ro.fasttrackit.curs2.oop.inheritance;

public class Base {

  Base myMethod() {
    System.out.println ("public");
    return null;
  }
}


class Child extends Base {
  @Override
  public Child myMethod() {
    System.out.println ("child");
    return null;
  }
}
