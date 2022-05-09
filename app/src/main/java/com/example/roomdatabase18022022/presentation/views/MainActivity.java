package com.example.roomdatabase18022022.presentation.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.roomdatabase18022022.R;
import com.example.roomdatabase18022022.data.local.entities.NoteWord;
import com.example.roomdatabase18022022.presentation.viewmodels.MainViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(getApplication());
            }
        }).get(MainViewModel.class);

        mainViewModel.getNotesList().observe(this, new Observer<List<NoteWord>>() {
            @Override
            public void onChanged(List<NoteWord> noteWords) {
                for (int i = 0; i < noteWords.size(); i++) {
                    Log.d("BBB",noteWords.get(i).toString());
                }
            }
        });

        mainViewModel.queryNotesList();
        mainViewModel.insertNote(new NoteWord("Work 2" , "Do something 2"));
    }

}
