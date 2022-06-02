package ro.fasttrackit.homeworkCurs4.ex3;

record Cat(String name) implements Animal{

  @Override
  public String makeNoise() {
    return "miau miau";
  }
}
