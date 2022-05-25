package ro.fasttrackit.curs3.homework;

public enum CelestialBody implements Transformable{
  TERRA (1){
    @Override
    public double getMass(int init) {
      return 0;
    }
  },
  MERCURY (2.4) {
    @Override
    public double getMass(int init) {
      return 1;
    }

    @Override
    public String getDescription() {
      return "mercury description ";
    }
  },
  VENUS (3) {
    @Override
    public double getMass(int init) {
      return 2;
    }

    public double getMass() {
      return 3;
    }
  };
  private final double ratio;

  CelestialBody(double ratio) {
    this.ratio = ratio;
  }

  public String getDescription() {
    return "generic description ";
  }
}

class CelestialClass {
  public final static CelestialClass TERRA = new CelestialClass (1);
  public final static CelestialClass MERCURY = new CelestialClass (1);
  public final static CelestialClass VENUS = new CelestialClass (1);

  private final double ratio;

  CelestialClass(double ratio) {
    this.ratio = ratio;
  }

  public double getRMass(int init) {
    return init * ratio;
  }
}
