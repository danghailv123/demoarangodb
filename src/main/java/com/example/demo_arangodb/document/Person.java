package com.example.demo_arangodb.document;


import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Document(value = "persons")
public class Person {
    @Id
//    db document field: _key
    private String id;

    @ArangoId
    // db document field: _id
    private String arangoId;

    private String firstName;
    private String lastName;
    private int age;
    private boolean alive;
    @Relations(edges = FriendsOf.class , lazy = true,maxDepth = 1,direction = Relations.Direction.ANY)
    private Collection<Person> friends;

    public Person() {
        super();
    }

    public Person(String firstName, String lastName, int age, boolean alive) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.alive = alive;
    }

    public String getId() {
        return id;
    }


    public String getArangoId() {
        return arangoId;
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

    public Collection<Person> getFriends() {
        return friends;
    }

    public void setFriends(Collection<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", arangoId='" + arangoId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                ", friends=" + friends +
                '}';
    }
}
