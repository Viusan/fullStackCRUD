package oslomet.fullstackcrud.controller;
import org.springframework.web.bind.annotation.*;

import oslomet.fullstackcrud.models.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.fullstackcrud.repository.personRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Person")
public class PersonController {
    private final personRepository repository;

    public PersonController(personRepository repository){
        this.repository = repository;
    }

    @PostMapping("/create")
    public void addPerson(@RequestBody Person person){//Without requestBody tells Spring to take the JSON body and convert it into a Java object (Person)
        repository.insertPerson(person);//Takes person and inserts it into the function inside personRepository
    }

    @PutMapping("/update")
    public void updatePerson(@RequestBody Person person){
        repository.updatePerson(person);
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestBody Person person){
        repository.deletePerson(person);
    }
    @GetMapping("/getAllUser")
    public List<Person> getAllPerson(){
        return repository.getAllPeople();
    }
}

