package ro.fasttrackit.curs2.overloading;

public class Car {
  //overloading
  private void drive(int speed, int direction) {
    System.out.println ("Driving with %s speed and direction".formatted (speed, direction));
  }

  private void drive(int speed) {
    drive (speed, 1);
  }

  private void drive() {
    drive (10);
  }
}
