package com.example.ieee_task1_noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerViewAdapter rvAdapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<DataModel> dataModelList = new ArrayList<>();
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));
        dataModelList.add(new DataModel("123","15/12/3"));

        rv = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);

        rvAdapter = new RecyclerViewAdapter(dataModelList,getApplicationContext());
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
    }
}