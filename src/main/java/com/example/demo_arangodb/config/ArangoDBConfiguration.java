package com.example.demo_arangodb.config;

import com.arangodb.ArangoDB;
import com.arangodb.Protocol;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories("com.example.demo_arangodb")
public class ArangoDBConfiguration implements ArangoConfiguration {


    @Override
    public ArangoDB.Builder arango() {
        ArangoDB.Builder arango = new ArangoDB.Builder()
                .host("127.0.0.1",8529)
                .useProtocol(Protocol.HTTP_JSON)
                .user("root")
                .password("haigay123");
        return arango;
    }

    @Override
    public String database() {
        return "test";
    }
}
