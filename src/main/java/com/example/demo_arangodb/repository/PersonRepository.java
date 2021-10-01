package com.example.demo_arangodb.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.annotation.QueryOptions;
import com.arangodb.springframework.repository.ArangoRepository;
import com.example.demo_arangodb.document.Person;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends ArangoRepository<Person,String> {
    Iterable<Person> findByFirstName(String firstName);
    Iterable<Person> findByFirstNameAndLastName(String firstName ,String lastName);
    Iterable<Person> findByLastName(String lastName);

    @Query("FOR c IN persons FILTER  c.age > @age RETURN c")
    Iterable<Person> findPersonByAge(@Param("age") int value);
}
