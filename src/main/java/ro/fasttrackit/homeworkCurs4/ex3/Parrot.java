package ro.fasttrackit.homeworkCurs4.ex3;

public final class Parrot extends Bird {

  protected Parrot(String type) {
    super (type);
  }

  @Override
  public String makeNoise() {
      return "parrot noise";
  }
}
