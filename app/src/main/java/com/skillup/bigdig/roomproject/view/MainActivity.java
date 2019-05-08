package com.skillup.bigdig.roomproject.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.skillup.bigdig.roomproject.R;
import com.skillup.bigdig.roomproject.entity.Person;
import com.skillup.bigdig.roomproject.room.PersonRoomDataStore;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();
    private PersonRoomDataStore dataStore;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dataStore = new PersonRoomDataStore(this);
        compositeDisposable = new CompositeDisposable();
    }

    @OnClick(R.id.bt_add)
    void add() {
        compositeDisposable.add(
                dataStore.addPerson(new Person("vasya", "vasyapupkin@it.ua"))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe());
    }

    @OnClick(R.id.bt_delete)
    void delete() {
        if (personList.size() > 0) {
            compositeDisposable.add(
                    dataStore.deletePerson(personList.get(personList.size() - 1))
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(() -> personList.remove(personList.size() - 1))
            );
        }
    }

    @OnClick(R.id.bt_get_all)
    void getAll() {
        compositeDisposable.add(
                dataStore.getAll()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(list -> {
                            personList = list;
                            for (Person p :
                                    personList) {
                                Log.d("danil", p.toString());
                            }
                        })
        );
    }
}
