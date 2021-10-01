package com.example.demo_arangodb.controller;


import com.example.demo_arangodb.document.Person;
import com.example.demo_arangodb.dto.PersonDTO;
import com.example.demo_arangodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
public class ControllerPerson {
    @Autowired
    PersonService personService;

    @PostMapping("")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
            personService.addPerson(personDTO);
        return ResponseEntity.ok(personDTO);
    }


    @GetMapping("")
    public Iterable<Person> getAll(){
        return personService.findAllPerson();
    }

//    {
//        "id": "14056",
//            "arangoId": "persons/14056",
//            "firstName": "HairNew",
//            "lastName": "DangNew",
//            "age": 22,
//            "alive": false,
//            "friends": []
//    }
    @PutMapping("")
    public Person updatePerson(@RequestBody Person person ){
        return personService.updatePerson(person);
    }

    @PutMapping("/{id}")
    public Person deletePerson(@PathVariable("id") String id){
        return personService.deletePerson(id);
    }

    @PostMapping("/add-friend")
    public Person addFriend(@RequestParam String id1,@RequestParam String id2 ){
        return personService.addFriend(id1,id2);
    }

}
