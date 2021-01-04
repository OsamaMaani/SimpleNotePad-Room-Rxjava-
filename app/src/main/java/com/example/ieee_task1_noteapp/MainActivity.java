package com.example.ieee_task1_noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerViewAdapter rvAdapter;
    FloatingActionButton fab;
    CardView mCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardView = findViewById(R.id.noteCard);

        rv = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);

        rvAdapter = new RecyclerViewAdapter();
        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this
                       ,SecondActivity.class);
               startActivity(intent);
            }
        });



        final NoteDatabase noteDatabase = NoteDatabase.getInstance(this);
        noteDatabase.mNotesDao().getAllNotes()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<DataModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<DataModel> dataModels) {
                       rvAdapter.setList(dataModels);
                       rvAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });




     mCardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             noteDatabase.mNotesDao().delete(v.getId())
                     .subscribeOn(Schedulers.computation())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(new CompletableObserver() {
                         @Override
                         public void onSubscribe(Disposable d) {

                         }

                         @Override
                         public void onComplete() {
                             Toast.makeText(getApplicationContext(),
                                     "Deleted Item",Toast.LENGTH_LONG).show();
                         }

                         @Override
                         public void onError(Throwable e) {

                         }
                     }) ;
         }
     });

    }
}