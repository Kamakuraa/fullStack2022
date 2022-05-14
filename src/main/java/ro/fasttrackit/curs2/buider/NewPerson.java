package ro.fasttrackit.curs2.buider;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewPerson {
  private String name;
  private int age;
  private String address;
  private boolean married;
}


@With
@Builder
@Value
class PersonLombok{
  String name;
  int age;
}
