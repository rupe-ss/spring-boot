package com.springboot.service;

import com.springboot.dao.PersonDAO;
import com.springboot.model.Person;

public class PersonService {

    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person){
        return personDAO.addPerson(person);
    }
}
