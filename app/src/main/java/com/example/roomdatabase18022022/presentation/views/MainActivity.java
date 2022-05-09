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

        mainViewModel.getListNotes().observe(this, new Observer<List<NoteWord>>() {
            @Override
            public void onChanged(List<NoteWord> noteWords) {
                Log.d("BBB",noteWords.size() + "");
            }
        });

    }
}
