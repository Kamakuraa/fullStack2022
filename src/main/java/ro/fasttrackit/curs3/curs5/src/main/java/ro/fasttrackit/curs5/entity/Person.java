package ro.fasttrackit.curs5.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Person {
  int id;
  String name;
  int age;
}
