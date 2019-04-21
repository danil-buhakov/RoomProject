package com.skillup.bigdig.roomproject.room;

import android.content.Context;

import com.skillup.bigdig.roomproject.entity.Person;
import com.skillup.bigdig.roomproject.view.IDataStore;

import java.util.List;

public class PersonRoomDataStore implements IDataStore {

    private PersonDAO personDAO;

    public PersonRoomDataStore(Context context){
        personDAO = AppDatabaseProvider.getInstance(context).personDAO();
    }

    @Override
    public void addPerson(Person person) {
        personDAO.insert(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDAO.delete(person);
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }
}
