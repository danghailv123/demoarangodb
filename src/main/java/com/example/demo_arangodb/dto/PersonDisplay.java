package com.example.demo_arangodb.dto;

import com.arangodb.springframework.annotation.Relations;
import com.example.demo_arangodb.document.FriendsOf;
import com.example.demo_arangodb.document.Person;

import java.util.Collection;

public class PersonDisplay {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean alive;
    private Collection<PersonDTO> friends;


    public PersonDisplay(String id, String firstName, String lastName, int age, boolean alive, Collection<PersonDTO> friends) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.alive = alive;
        this.friends = friends;
    }

    public PersonDisplay() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Collection<PersonDTO> getFriends() {
        return friends;
    }

    public void setFriends(Collection<PersonDTO> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "PersonDisplay{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                ", friends=" + friends +
                '}';
    }
}
