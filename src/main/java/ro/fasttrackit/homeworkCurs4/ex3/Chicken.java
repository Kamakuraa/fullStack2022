package ro.fasttrackit.homeworkCurs4.ex3;

public non-sealed class Chicken extends Bird{
  private final String color;

  public Chicken(String type, String color) {
    super (type);
    this.color = color;
  }

  @Override
  public String makeNoise() {
    return "piu piu";
  }
}
