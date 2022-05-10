package ro.fasttrackit.curs2;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.With;


@Data
@Builder
public class NewPerson {
  private final String name;
  private final int age;

}
@With
@Value
@Builder
class PersonLombok{
  String name;
  int age;
}
