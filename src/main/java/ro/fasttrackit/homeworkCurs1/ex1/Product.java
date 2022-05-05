package ro.fasttrackit.homeworkCurs1.ex1;

import java.util.*;

public class Product {
  private final String name;
  private final int price;
  private final List<Category> categories;
  private final String description;

  public Product(String name, int price, List<Category> categories, String description) {
    this.name = name;
    this.price = price;
    if (categories != null) {
      this.categories = new ArrayList<> (categories);
    } else {
      this.categories = new ArrayList<> ();
    }
    this.description = description;
  }


  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Product project = (Product) o;
    return price == project.price && Objects.equals (name, project.name) && Objects.equals (categories, project.categories) && Objects.equals (description, project.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash (name, price, categories, description);
  }

  @Override
  public String toString() {
    return "Project{" +
      "name='" + name + '\'' +
      ", price=" + price +
      ", categories=" + categories +
      ", description='" + description + '\'' +
      '}';
  }

  static class ProjectBuilder {
    private String name;
    private int price;
    private List<Category> categories;
    private String description;

    public static ProjectBuilder project() {
      return new ProjectBuilder ();
    }

    public ProjectBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ProjectBuilder price(int price) {
      this.price = price;
      return this;
    }

    public ProjectBuilder categories(Category categories) {
      this.categories = Collections.singletonList (categories);
      return this;
    }

    public ProjectBuilder description(String description) {
      this.description = description;
      return this;
    }

    public Product build() {
      return new Product (name, price, categories, description);
    }
  }
}
