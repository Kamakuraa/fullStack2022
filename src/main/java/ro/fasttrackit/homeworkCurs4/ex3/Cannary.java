package ro.fasttrackit.homeworkCurs4.ex3;

import java.util.Objects;

public final class Cannary extends Bird {
  private final String name;

  public Cannary(String type, String name) {
    super (type);
    this.name = name;
  }


  @Override
  public String makeNoise() {
    return "Canary noise";
  }

  public String name() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass () != this.getClass ()) return false;
    var that = (Cannary) obj;
    return Objects.equals (this.name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash (name);
  }

  @Override
  public String toString() {
    return "Cannary[" +
      "name=" + name + ']';
  }

}
