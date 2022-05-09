package com.example.roomdatabase18022022.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase18022022.data.local.DatabaseManager;
import com.example.roomdatabase18022022.data.local.daos.NoteDao;
import com.example.roomdatabase18022022.data.local.entities.NoteWord;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application){
        noteDao = DatabaseManager.getDatabase(application).getNoteDao();
    }

    public LiveData<List<NoteWord>> getListNotes(){
        return noteDao.getListNote();
    }
}
