package ro.fasttrackit.homeworkCurs1.ex1;

import lombok.*;

import java.util.List;

@Data
@Builder
public class ProductWithLombok {
  String name;
  int price;
  List<Category> categories;
  String description;
}
