package com.skillup.bigdig.roomproject.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.skillup.bigdig.roomproject.entity.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDAO personDAO();
}
