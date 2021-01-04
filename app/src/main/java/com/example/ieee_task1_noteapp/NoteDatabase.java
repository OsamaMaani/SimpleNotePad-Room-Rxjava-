package com.example.ieee_task1_noteapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = DataModel.class, version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase instance;
    public abstract NotesDao mNotesDao();

    public static synchronized NoteDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class,"note_database")
            .fallbackToDestructiveMigration()
                    .build();
            ;
        }
        return instance;
    }
}
