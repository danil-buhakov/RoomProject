package com.skillup.bigdig.roomproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.skillup.bigdig.roomproject.R;
import com.skillup.bigdig.roomproject.entity.Person;
import com.skillup.bigdig.roomproject.room.AppDatabaseProvider;
import com.skillup.bigdig.roomproject.room.PersonDAO;
import com.skillup.bigdig.roomproject.room.PersonRoomDataStore;
import com.skillup.bigdig.roomproject.sqlite.PersonSqliteDataStore;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();
    private IDataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dataStore = new PersonRoomDataStore(this);
//        dataStore = new PersonSqliteDataStore(this);
    }

    @OnClick(R.id.bt_add)
    void add() {
        dataStore.addPerson(new Person("vasya","vasyapupkin@it.ua"));
    }

    @OnClick(R.id.bt_delete)
    void delete() {
        if (personList.size() > 0) {
            dataStore.deletePerson(personList.get(personList.size()-1));
            personList.remove(personList.size()-1);
        }
    }

    @OnClick(R.id.bt_get_all)
    void getAll() {
        personList = dataStore.getAll();
        for (Person p :
                personList) {
            Log.d("danil",p.toString());
        }
    }
}
