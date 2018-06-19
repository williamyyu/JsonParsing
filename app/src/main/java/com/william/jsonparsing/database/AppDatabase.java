package com.william.jsonparsing.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.william.jsonparsing.database.pojos.Data;

@Database(entities = {Data.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sAppDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (sAppDatabase == null) {
            synchronized (AppDatabase.class) {
                if (sAppDatabase == null) {
                    sAppDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "database-name").fallbackToDestructiveMigration().build();
                }
            }
        }
        return sAppDatabase;
    }

    public abstract DataDao dataDao();
}
