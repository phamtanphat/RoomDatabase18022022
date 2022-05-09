package com.example.roomdatabase18022022.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase18022022.data.local.DatabaseManager;
import com.example.roomdatabase18022022.data.local.daos.NoteDao;
import com.example.roomdatabase18022022.data.local.entities.NoteWord;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application){
        noteDao = DatabaseManager.getDatabase(application).getNoteDao();
    }

    public Observable<List<NoteWord>> getListNotes(){
        return noteDao.getListNote();
    }

    public Completable insertNote(NoteWord noteWord){
        return noteDao.insertNote(noteWord);
    }
}
