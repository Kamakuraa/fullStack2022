package ro.fasttrackit.homeworkCurs1.ex1;

import lombok.*;

import java.util.List;

@Data
@Builder
public class ProductWithLombok {
  private String name;
  private int price;
  private List<Category> categories;
  private String description;
}
