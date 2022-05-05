package ro.fasttrackit.homeworkCurs1.ex1;

import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    Product product = Product.ProjectBuilder.project ()
      .name ("Laptop")
      .price (1200)
      .categories (Category.ELECTRONICS)
      .description ("Macbook pro")
      .build ();

    System.out.println (product);




    // with lombok

    ProductWithLombok product2 = ProductWithLombok.builder()
      .name ("T-shirt")
      .price (25)
      .categories (Collections.singletonList (Category.CLOTHES))
      .description ("Under Armour running t-shirt")
      .build();

    System.out.println (product2);
  }

}
