package com.skillup.bigdig.roomproject.room;

import android.content.Context;

import com.skillup.bigdig.roomproject.entity.Person;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;

public class PersonRoomDataStore {

    private PersonDAO personDAO;

    public PersonRoomDataStore(Context context){
        personDAO = AppDatabaseProvider.getInstance(context).personDAO();
    }

    public Completable addPerson(Person person) {
        return Completable.fromAction(() -> personDAO.insert(person));
    }

    public Completable deletePerson(Person person) {
        return Completable.fromAction(() -> personDAO.delete(person));
    }

    public Single<List<Person>> getAll() {
        return personDAO.getAll();
    }
}
