package com.skillup.bigdig.roomproject.di;

import android.content.Context;

import com.skillup.bigdig.roomproject.room.PersonRoomDataStore;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    Context context;

    public RoomModule(Context context){
        this.context = context;
    }

    @Provides
    public PersonRoomDataStore providePersonDataStore(){
        return new PersonRoomDataStore(context);
    }
}
