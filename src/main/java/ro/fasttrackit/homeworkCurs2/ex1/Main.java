package ro.fasttrackit.homeworkCurs2.ex1;

import java.util.List;

public class Main{
  public static void main(String[] args) {
    PlanetService planetService = new PlanetService (List.of (
      Gravity.GANYMEDE,
      Gravity.NEPTUNE,
      Gravity.CALLISTO,
      Gravity.EUROPA,
      Gravity.JUPITER
    ));
    System.out.println (planetService.getGravityBodies ());

    System.out.println (planetService.getGravityWithLargeGravity (0.5));

  }
}
