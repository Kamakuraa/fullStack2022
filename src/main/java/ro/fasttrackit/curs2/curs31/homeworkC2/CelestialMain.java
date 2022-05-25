package ro.fasttrackit.curs2.curs31.homeworkC2;

public class CelestialMain {
  public static void main(String[] args) {
    System.out.println (CelestialBody.MERCURY.getPosition ());
    System.out.println (CelestialBody.TERRA.getDescription ());
    System.out.println (CelestialBody.TERRA.getMass (1));
    System.out.println (CelestialBody.of ("MERCURY").orElse (CelestialBody.TERRA));
    System.out.println (CelestialBody.valueOf ("TERRA"));

    System.out.println (CelestialBodyClass.TERRA.getClass ());
    System.out.println (CelestialBodyClass.MERCURY.getClass ());
  }
}
