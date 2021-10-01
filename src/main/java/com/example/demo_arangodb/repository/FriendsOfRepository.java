package com.example.demo_arangodb.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.demo_arangodb.document.FriendsOf;
import org.springframework.stereotype.Repository;


@Repository
public interface FriendsOfRepository extends ArangoRepository<FriendsOf,String> {
}