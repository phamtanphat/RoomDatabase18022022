package com.example.roomdatabase18022022.presentation.views;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdatabase18022022.R;
import com.example.roomdatabase18022022.presentation.viewmodels.MainViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
//            @NonNull
//            @Override
//            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//                return (T) new MainViewModel(getApplication());
//            }
//        }).get(MainViewModel.class);
//
//        mainViewModel.getNotesList().observe(this, new Observer<List<NoteWord>>() {
//            @Override
//            public void onChanged(List<NoteWord> noteWords) {
//                for (int i = 0; i < noteWords.size(); i++) {
//                    Log.d("BBB",noteWords.get(i).toString());
//                }
//            }
//        });
//
//        mainViewModel.queryNotesList();
//        mainViewModel.insertNote(new NoteWord("Work 2" , "Do something 2"));

        Observable<String> stringObservable = Observable.just("A","B","C");


        stringObservable
                .subscribeOn(Schedulers.io())
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Throwable {
                        Log.d("BBB",Thread.currentThread().getName());
                        return s + " " + count++;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
//                        Log.d("BBB",s);
                        Log.d("BBB",Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
