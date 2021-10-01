package com.example.demo_arangodb.service;

import com.example.demo_arangodb.document.FriendsOf;
import com.example.demo_arangodb.document.Person;
import com.example.demo_arangodb.dto.PersonDTO;
import com.example.demo_arangodb.dto.mapper.PersonMapper;
import com.example.demo_arangodb.repository.FriendsOfRepository;
import com.example.demo_arangodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FriendsOfRepository friendsOfRepository;
    @Override
    public Person addPerson(PersonDTO personDTO) {
        Person person = PersonMapper.mapperPersonDTOtoPerson(personDTO);
        return personRepository.save(person);
    }

    @Override
    public Iterable<Person> addListPerson(List<PersonDTO> personDTOS) {
        List<Person> personList = new ArrayList<>();
        for (PersonDTO personDTO: personDTOS
             ) {
            personList.add(PersonMapper.mapperPersonDTOtoPerson(personDTO));
        }
        return personRepository.saveAll(personList);
    }


    @Override
    public Person updatePerson(Person person) {
        String personId=person.getId();

        if(personRepository.existsById(personId)){
            person.setFriends(personRepository.findById(personId).get().getFriends());
            return personRepository.save(person);
        }
        return null;
    }

    @Override
    public Person deletePerson(String id) {
        if(personRepository.existsById(id)){
            Person person = personRepository.findById(id).get();
            personRepository.deleteById(id);
            return person;
        }
        return null;
    }

    @Override
    public Optional<Person> findOnePerson(String id) {
        if(id==null||id.isEmpty()){
            return null;
        }
        return personRepository.findById(id);
    }

    @Override
    public Iterable<Person> findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    @Override
    public Iterable<Person> findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    @Override
    public Iterable<Person> findByFirstNameAndLastName(String firstName,String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public Iterable<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Iterable<Person> findAllPersonPage(int page) {
        return personRepository.findAll(PageRequest.of(page, 10,Sort.by(Sort.Direction.ASC,"firstName")));
    }

//    @Override
//    public Iterable<Person> findPersonByAge(int age) {
//        return personRepository.findPersonByAge(age);
//    }

    @Override
    public Person addFriend(String id1,String id2) {
        if(id2.isEmpty()||id2==null||!personRepository.existsById(id2)){
            return null;
        }

        Optional<Person> person1 = personRepository.findById(id1);
        Optional<Person> person2= personRepository.findById(id2);
        FriendsOf friendsOf = new FriendsOf(person1.get(),person2.get());
        friendsOfRepository.save(friendsOf);
        return person2.get();
    }

    @Override
    public Person deleteFriend(String id1, String id2) {
        Optional<Person> person1 = personRepository.findById(id1);
        Optional<Person> person2= personRepository.findById(id2);
        FriendsOf friendsOf = new FriendsOf(person1.get(),person2.get());
        friendsOfRepository.save(friendsOf);

        return person2.get();
    }


}
