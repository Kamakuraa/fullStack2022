package ro.fasttrackit.homeworkCurs1.ex2;

import ro.fasttrackit.homeworkCurs1.ex1.Category;
import ro.fasttrackit.homeworkCurs1.ex1.Product;

import java.util.*;

public class Shop {
  private final Map<Product, Integer> products = new HashMap<> ();

  public Shop(Product product, Integer amount) {
    this.products.put (product, amount);
  }

  public Shop(Product product) {
    this (product, 1);
  }

  public Map<Product, Integer> getProducts() {
    return Collections.unmodifiableMap (products);
  }

  public void addProduct(Product product) {
    addProductToList (product, 1);
  }

  private void addProductToList(Product product, Integer amount) {
    if (!isProduct (product)) {
      this.products.put (product, amount);
      System.out.println ("Products " + product.getName () + " added to inventory");
    } else {
      this.products.put (product, this.products.get (product) + amount);
      System.out.println ("Product " + product.getName () + " is already in the inventory");
    }
  }

  private boolean isProduct(Product product) {
    return this.products.containsKey (product);
  }

  public void buyProduct(Product product, Integer amount) {
    if (isProduct (product)) {
      int availableAmount = this.products.get (product);
      if (!isEnoughAmountToBuy (product, amount)) {
        amount = getNewAmount (availableAmount);
      }
      productBought (product, amount, availableAmount);
    } else {
      System.out.println (" There is no " + product.getName () + " product in the inventory!");
    }
  }

  private void productBought(Product product, Integer amount, int availableAmount) {
    if (amount > 0) {
      if (availableAmount - amount == 0) {
        this.products.remove (product);
      } else {
        this.products.put (product, availableAmount - amount);
      }
      System.out.println ("You just just bought " + amount + " " + product.getName ());
    }
  }

  private Integer getNewAmount(int availableAmount) {
    int amount = 0;
    do {
      System.out.println ("your number exceeded the curently available amount " + availableAmount);
      System.out.println ("Please select another amount");
      Scanner scanner = new Scanner (System.in);
      amount = scanner.nextInt ();
    } while (amount != 0 && amount > availableAmount);
    return amount;
  }

  private boolean isEnoughAmountToBuy(Product product, Integer amount) {
    return this.products.get (product) >= amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass () != o.getClass ()) return false;
    Shop shop = (Shop) o;
    return Objects.equals (products, shop.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash (products);
  }

  @Override
  public String toString() {
    return "Shop{" +
      "products=" + products +
      '}';
  }

  public static void main(String[] args) {
    Shop shop = new Shop (new Product ("Laprop", 1200, List.of (Category.ELECTRONICS), "MacBook Pro"), 1);

    System.out.println (shop.isEnoughAmountToBuy (new Product ("Laprop", 1200, List.of (Category.ELECTRONICS), "MacBook Pro"), 1));


    System.out.println (shop.getNewAmount (1));
    shop.buyProduct (new Product ("Laprop", 1200, List.of (Category.ELECTRONICS), "MacBook Pro"), 1);
    System.out.println (shop);
  }
}
