package com.springboot.dao;

import com.springboot.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocalDataAccessService implements PersonDAO{

    private static List<Person> personDBTable = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDBTable.add(new Person(id, person.getName()));
        return 1;
    }

}
