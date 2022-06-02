package ro.fasttrackit.homeworkCurs4.ex3;

public non-sealed interface Insects extends Animal {
  boolean isFlying();
}

record LadyBug() implements Insects{

  @Override
  public String makeNoise() {
    return "bee noise";
  }

  @Override
  public boolean isFlying() {
    return false;
  }
}

class Fly implements Insects{

  @Override
  public String makeNoise() {
    return "Bzzzzzz";
  }

  @Override
  public boolean isFlying() {
    return true;
  }
}
