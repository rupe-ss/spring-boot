package com.springboot.dao;

import com.springboot.model.Person;

import java.util.UUID;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
