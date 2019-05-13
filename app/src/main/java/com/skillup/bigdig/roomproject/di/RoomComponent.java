package com.skillup.bigdig.roomproject.di;

import com.skillup.bigdig.roomproject.room.PersonRoomDataStore;

import dagger.Component;

@Component(modules = RoomModule.class)
public interface RoomComponent {
    PersonRoomDataStore getRoomDataStore();
}
