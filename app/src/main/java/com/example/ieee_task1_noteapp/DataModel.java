package com.example.ieee_task1_noteapp;

public class DataModel{

    private String title;
    private String dateTime;

    public DataModel(String title, String dateTime){
        this.title = title;
        this.dateTime = dateTime;
    }


    public String getTitle() {
        return title;
    }

    public String getDateTime() {
        return dateTime;
    }
}
