package com.william.jsonparsing.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.william.jsonparsing.database.pojos.Data;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM data")
    List<Data> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Data... data);

    @Delete
    void delete(Data data);
}