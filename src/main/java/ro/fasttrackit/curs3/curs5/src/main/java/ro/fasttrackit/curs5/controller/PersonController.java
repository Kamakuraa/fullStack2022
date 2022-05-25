package ro.fasttrackit.curs5.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs5.entity.Person;
import ro.fasttrackit.curs5.service.PersonService;

import javax.management.openmbean.CompositeData;
import java.util.List;

@RestController
@RequestMapping("persons")
@AllArgsConstructor
public class PersonController {
  private PersonService service;

//  public PersonController(PersonService service) {
//    this.service = service;
//  }

  @GetMapping
  List<Person> getAllPersons(@RequestParam(required = false) String name) {
    return service.getAll (name);
  }

  @GetMapping("{personId}")
  Person getPerson(@PathVariable int personId) {
    return service.getPersorn (personId)
      .orElseThrow (() -> new RuntimeException ("could not find person with id " + personId));
  }
}
