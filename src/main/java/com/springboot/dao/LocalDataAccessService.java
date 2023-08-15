package com.springboot.dao;

import com.springboot.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Qualifier("local")
public class LocalDataAccessService implements PersonDAO{

    private static List<Person> personDBTable = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personDBTable.add(new Person(id, person.getName()));
        return 1;
    }

}
