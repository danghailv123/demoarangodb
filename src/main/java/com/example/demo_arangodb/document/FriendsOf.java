package com.example.demo_arangodb.document;


import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import org.springframework.data.annotation.Id;

@Edge
public class FriendsOf {
    @Id
    private String id;

    @From
    private Person personOne;

    @To
    private Person personTwo;

    public FriendsOf(Person personOne, Person personTwo) {
        super();
        this.personOne = personOne;
        this.personTwo = personTwo;
    }


    public String getId() {
        return id;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public void setPersonOne(Person personOne) {
        this.personOne = personOne;
    }

    public Person getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(Person personTwo) {
        this.personTwo = personTwo;
    }

    @Override
    public String toString() {
        return "FriendsOf{" +
                "id='" + id + '\'' +
                ", personOne=" + personOne +
                ", personTwo=" + personTwo +
                '}';
    }
}
