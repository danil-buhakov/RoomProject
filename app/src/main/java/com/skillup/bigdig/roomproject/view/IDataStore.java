package com.skillup.bigdig.roomproject.view;

import com.skillup.bigdig.roomproject.entity.Person;

import java.util.List;

public interface IDataStore {
    void addPerson(Person person);
    void deletePerson(Person person);
    List<Person> getAll();
}
