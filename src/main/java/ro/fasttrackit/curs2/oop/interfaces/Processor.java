package ro.fasttrackit.curs2.oop.interfaces;

public interface Processor {
  int value();
  default void execute(){
    System.out.println (value());
  }
}

record IntProcessor(int value)implements Processor{}
