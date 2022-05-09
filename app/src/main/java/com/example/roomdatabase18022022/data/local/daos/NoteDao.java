package com.example.roomdatabase18022022.data.local.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatabase18022022.data.local.entities.NoteWord;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    Observable<List<NoteWord>> getListNote();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertNote(NoteWord noteWord);
}
