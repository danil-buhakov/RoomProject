package com.skillup.bigdig.roomproject.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.skillup.bigdig.roomproject.entity.Person;

import java.util.List;

@Dao
public interface PersonDAO {
    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person WHERE id = :id")
    Person getById(long id);

    @Insert
    void insert(Person employee);

    @Update
    void update(Person employee);

    @Delete
    void delete(Person employee);
}
