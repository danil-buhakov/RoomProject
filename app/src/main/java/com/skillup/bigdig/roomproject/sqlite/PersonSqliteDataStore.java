package com.skillup.bigdig.roomproject.sqlite;

import android.content.Context;

import com.skillup.bigdig.roomproject.entity.Person;
import com.skillup.bigdig.roomproject.view.IDataStore;

import java.util.List;

public class PersonSqliteDataStore implements IDataStore {

    private Context context;

    public PersonSqliteDataStore(Context context){
        this.context = context;
    }

    @Override
    public void addPerson(Person person) {
        PersonTable.addPerson(person, context);
    }

    @Override
    public void deletePerson(Person person) {
        PersonTable.deletePerson(person, context);
    }

    @Override
    public List<Person> getAll() {
        return PersonTable.getAll(context);
    }
}
