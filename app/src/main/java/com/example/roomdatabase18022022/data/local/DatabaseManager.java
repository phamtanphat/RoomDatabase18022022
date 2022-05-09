package com.example.roomdatabase18022022.data.local;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase18022022.data.local.daos.NoteDao;
import com.example.roomdatabase18022022.data.local.entities.NoteWord;

@Database(entities = NoteWord.class, version = 1)
public abstract class DatabaseManager extends RoomDatabase {
    private static DatabaseManager databaseManager = null;

    public abstract NoteDao getNoteDao();

    public static DatabaseManager getDatabase(Application context) {
        if (databaseManager == null) {
            databaseManager = Room.databaseBuilder(
                    context,
                    DatabaseManager.class,
                    "note-database"
            ).build();
        }
        return databaseManager;
    }
}
