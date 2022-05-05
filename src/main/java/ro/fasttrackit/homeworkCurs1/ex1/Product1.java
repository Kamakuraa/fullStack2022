package ro.fasttrackit.homeworkCurs1.ex1;

import java.util.ArrayList;
import java.util.List;

public class Product1 {
  private String name;
  private int price;
  private List<Category> categories;
  private String description;

  public Product1() {
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public List<Category> getCategories() {
    return new ArrayList<> (categories);
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "Product1{" + "name='" + name + '\'' + ", price=" + price + ", categories=" + categories + ", description='" + description + '\'' + '}';
  }

  static class ProductBuilder {

    private final Product1 product1 = new Product1 ();

    public static ProductBuilder product1() {
      return new ProductBuilder ();
    }

    public Product1.ProductBuilder name(String name) {
      this.product1.name = name;
      return this;
    }

    public Product1.ProductBuilder price(int price) {
      this.product1.price = price;
      return this;
    }

    public Product1.ProductBuilder category(List<Category> categories) {
//      this.product1.categories = categories;
//      return this;
      if (categories != null) {
        this.product1.categories = new ArrayList<> (categories);
      } else {
        this.product1.categories = new ArrayList<> ();
      }
      return this;
    }

    public Product1.ProductBuilder description(String description) {
      this.product1.description = description;
      return this;
    }

    public Product1 build() {
      return product1;
    }
  }

  public static void main(String[] args) {
    Product1 product = ProductBuilder.product1 ().name ("TV").category (List.of (Category.ELECTRONICS)).price (400).description ("Samsung").build ();

    System.out.println (product);


  }
}
