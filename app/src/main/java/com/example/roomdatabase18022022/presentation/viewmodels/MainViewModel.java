package com.example.roomdatabase18022022.presentation.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabase18022022.data.local.entities.NoteWord;
import com.example.roomdatabase18022022.data.repository.NoteRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
    }

    public LiveData<List<NoteWord>> getListNotes() {
        return noteRepository.getListNotes();
    }

}
