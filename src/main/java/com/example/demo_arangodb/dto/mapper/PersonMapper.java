package com.example.demo_arangodb.dto.mapper;

import com.example.demo_arangodb.document.Person;
import com.example.demo_arangodb.dto.PersonDTO;
import com.example.demo_arangodb.dto.PersonDisplay;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {
    public static Person mapperPersonDTOtoPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setAlive(personDTO.isAlive());
        person.setAge(personDTO.getAge());
        return person;
    }

    public static PersonDisplay mapperPersonToPersonDisplay(Person person){
        PersonDisplay personDisplay = new PersonDisplay();
        personDisplay.setFirstName(person.getFirstName());
        personDisplay.setLastName(person.getLastName());
        personDisplay.setAge(person.getAge());
        personDisplay.setAlive(person.isAlive());
        while (person.getFriends().iterator().hasNext()){
            personDisplay.getFriends().add(mapperPersontoPersonDTO(person.getFriends().iterator().next()));
            person.getFriends().iterator().next();
        }
        return  personDisplay;

    }

    public static PersonDTO mapperPersontoPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAge(person.getAge());
        personDTO.setAlive(person.isAlive());
        return personDTO;
    }

}
