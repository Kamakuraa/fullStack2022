package ro.fasttrackit.homeworkCurs4.ex3;


sealed public interface Animal permits Dog, Cat, Bird, Insects {
  public String makeNoise();
}
