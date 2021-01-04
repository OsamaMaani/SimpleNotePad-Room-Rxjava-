package com.example.ieee_task1_noteapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_items")
public class DataModel{

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String dateTime;

    public DataModel(String title, String dateTime){
        this.title = title;
        this.dateTime = dateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDateTime() {
        return dateTime;
    }
}
