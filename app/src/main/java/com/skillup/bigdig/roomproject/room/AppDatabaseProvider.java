package com.skillup.bigdig.roomproject.room;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.skillup.bigdig.roomproject.room.AppDatabase;

public class AppDatabaseProvider {
    private static final String DATABASE_NAME = "RoomProject.db";
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
