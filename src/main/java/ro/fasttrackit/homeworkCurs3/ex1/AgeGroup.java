package ro.fasttrackit.homeworkCurs3.ex1;

public enum AgeGroup {
  YOUNG(0, 30),
  MEDIUM(31, 50),
  OLD(51, 99);

  private final int start;
  private final int end;

  AgeGroup(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }
}
