package ro.fasttrackit.curs3.javaFeature.curs4;

public class Java14Feature {
  public static void main(String[] args) {
    switchExpress ();
    betterNPE();
  }

  private static void betterNPE() {
  String name = null;
    System.out.println (name.length ());
  }

  private static void switchExpress() {
    String choice = "pizza";
    switch (choice) {
      case " burger":
        System.out.println ("delicious");
        break;
      case " salad":
        System.out.println ("Health");
        break;
      default:
        System.out.println ("food");
    }
    String result = switch (choice) {
      case "pizza", "burger":
        yield "Delicious";
      default:
        yield "food";
    };
    System.out.println (result);

    String res = switch (choice) {
      case "pizza", "burger" -> "delicious";
      case "salad"->{
        System.out.println ("green");
        yield "healthy";
      }
      default -> "food";
    };
    System.out.println (res);
  }
}
