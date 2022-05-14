package ro.fasttrackit.homeworkCurs2.ex1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlanetService {
  private final List<Gravity> gravityList = new ArrayList<> ();

  public PlanetService(Collection<Gravity> gravities) {
    if (gravities != null) {
      this.gravityList.addAll (gravities);
    }
  }

  public List<Gravity> getGravityBodies() {
    return Collections.unmodifiableList (gravityList);
  }

  public List<Gravity> getGravityWithLargeGravity(double gravity) {
    return gravityList.stream ()
      .filter (g -> g.getRatio () > gravity)
      .collect (Collectors.toList ());
  }
}
