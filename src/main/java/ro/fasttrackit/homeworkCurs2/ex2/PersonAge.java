package ro.fasttrackit.homeworkCurs2.ex2;

public enum PersonAge {
  CHILD(0, 12),
  YOUNG(13, 29),
  MATURE(30, 50),
  OLD(50, 99);

  private final int start;
  private final int end;

  PersonAge(int start, int end) {
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
