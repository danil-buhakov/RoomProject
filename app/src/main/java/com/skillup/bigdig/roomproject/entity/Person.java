package com.skillup.bigdig.roomproject.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;

    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Ignore
    public Person(String name, String email, int id){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(id)+" "+name+" "+email;
    }
}
