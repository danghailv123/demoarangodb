package com.example.demo_arangodb.service;

import com.example.demo_arangodb.document.Person;
import com.example.demo_arangodb.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface PersonService {
    Person addPerson(PersonDTO person);
    Iterable<Person> addListPerson(List<PersonDTO> personDTOS);
    Person updatePerson(Person person);
    Person deletePerson(String id);
    Optional<Person> findOnePerson(String id);
    Iterable<Person> findByFirstName(String firstName);
    Iterable<Person> findByLastName(String lastName);
    Iterable<Person> findByFirstNameAndLastName(String firstName,String lastName);
    Iterable<Person> findAllPerson();
    Iterable<Person> findAllPersonPage(int page);
//    Iterable<Person> findPersonByAge(int age);

    Person addFriend(String id1,String id2);
    Person deleteFriend(String id1,String id2);
}
