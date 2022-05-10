package ro.fasttrackit.curs2.oop;

public class PetMain {
  public static void main(String[] args) {
    Pet pet = new Pet ("Zorel") {
      @Override
      public String makeSound() {
        return "ham";
      }
    };

    System.out.println (pet.makeSound ());
  }

}
