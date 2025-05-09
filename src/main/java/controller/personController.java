package controller;

import models.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.personRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Person")
public class personController {
    private final personRepository repository;

    public personController(personRepository repository){
        this.repository = repository;
    }

    @PostMapping("/login")
    public List<Person> getAllPerson(){
        System.out.print(repository.getAllPerson());
        return repository.getAllPerson();
    }
}
