package ro.fasttrackit.curs2.oop.overloading;

public class Car {

  private void drive(){
    drive ( 10);
  }

  private void drive(int speed){
    drive (speed, 1);
  }
  private void drive(int speed, int direction){
    System.out.println ("Driving".formatted (speed, direction));
  }
}
