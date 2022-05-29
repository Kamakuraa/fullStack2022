package ro.fasttrackit.curs3.javaFeature.curs4;

public class Java13Features {
  public static void main(String[] args) {
    textBlock ();
  }

  private static void textBlock() {
    String json = """
      {
      "name":"Ana"
      }
      """;
    System.out.println (json);
  }
}
