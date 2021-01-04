package com.example.ieee_task1_noteapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
interface NotesDao {
    @Insert
    Completable insert(DataModel dataModel);

    @Query("select * from note_items")
    Single<List<DataModel>> getAllNotes();

    @Delete
    Completable delete(int id);
}
