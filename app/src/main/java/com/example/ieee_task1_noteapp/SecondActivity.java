package com.example.ieee_task1_noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SecondActivity extends AppCompatActivity {
    EditText etNote;
    Button btnSave,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etNote = findViewById(R.id.etNote);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z", Locale.getDefault());
        final String currentDateandTime = sdf.format(new Date());

        final NoteDatabase noteDatabase = NoteDatabase.getInstance(this);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(etNote.getEditableText().toString() != ""){
                     noteDatabase.mNotesDao()
                             .insert(new DataModel(etNote.getText().toString(), currentDateandTime))
                             .subscribeOn(Schedulers.computation())
                             .subscribe(new CompletableObserver() {
                                 @Override
                                 public void onSubscribe(Disposable d) {

                                 }

                                 @Override
                                 public void onComplete() {
                                     Intent intent = new
                                             Intent(SecondActivity.this, MainActivity.class);
                                     startActivity(intent);
                                 }

                                 @Override
                                 public void onError(Throwable e) {

                                 }
                             });
                 }else{
                     Toast.makeText(getApplicationContext(),
                             "Field is Empty",Toast.LENGTH_LONG).show();
                 }
            }
        });





    }
}